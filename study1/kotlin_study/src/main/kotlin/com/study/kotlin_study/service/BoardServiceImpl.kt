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
}