package com.study.kotlin_study.service

import com.study.kotlin_study.dto.response.BoardDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.repository.BoardRepository
import com.study.kotlin_study.repository.MemberRepository
import com.study.kotlin_study.service.impl.BoardService
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl (
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository
) : BoardService {

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
        val member = memberRepository.findById(board.memberId)
        val writer: String = member.get().nickname

        return toDTO(board, writer)
    }
}