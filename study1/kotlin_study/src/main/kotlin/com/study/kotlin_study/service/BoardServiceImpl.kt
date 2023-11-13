package com.study.kotlin_study.service

import com.study.kotlin_study.dto.request.BoardCreateRequest
import com.study.kotlin_study.dto.response.BoardDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.entity.Member
import com.study.kotlin_study.repository.BoardRepository
import com.study.kotlin_study.repository.MemberRepository
import com.study.kotlin_study.service.impl.BoardService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BoardServiceImpl (
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository
) : BoardService {
    val logger: Logger = LoggerFactory.getLogger(BoardService::class.java)

    override fun getBoardEntity(boardId: Long): Board {
        return boardRepository.findById(boardId).get()
    }

    private fun toDTO(board: Board, writer: String): BoardDTO {

        return BoardDTO(
            boardId = board.id,
            title = board.title,
            content = board.content,
            writer = writer,
            createTime = board.createTime,
            updateTime = board.updateTime
        )
    }
    override fun getBoard(boardId: Long): BoardDTO {
        val board = boardRepository.findById(boardId).get()
        val member: Member = memberRepository.findById(board.memberId)
        val writer: String = member.nickname

        logger.info("writer : {} boardId : {} ", writer, board.id)

        return toDTO(board, writer)
    }

    override fun createBoard(request: BoardCreateRequest, member: Member): BoardDTO {

        logger.info("title : {} writer: {}", request.title, member.nickname)

        val board = Board(
            title = request.title,
            content = request.content,
            createTime = LocalDateTime.now(),
            memberId = member.id
        )

        val result : Board = boardRepository.save(board)

        return toDTO(result, member.nickname)
    }

    override fun modifyBoard(request: BoardCreateRequest, boardId: Long , member: Member) {
        val board = boardRepository.findById(boardId).get()

        if(board.memberId != member.id) throw RuntimeException("자신의 글만 수정 가능")

        val result = Board(
            id = board.id,
            title = request.title,
            content = request.content,
            createTime = board.createTime,
            updateTime = LocalDateTime.now(),
            memberId = board.memberId
        )

        boardRepository.save(result)
    }

    override fun deleteBoard(board: Board, member: Member) {
        if(board.memberId != member.id) throw RuntimeException("자신의 글만 삭제 가능")

        boardRepository.delete(board)
    }
}