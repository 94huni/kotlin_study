package com.study.kotlin_study.service

import com.study.kotlin_study.dto.request.CommentRequest
import com.study.kotlin_study.dto.response.CommentDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.entity.Comment
import com.study.kotlin_study.entity.Member
import com.study.kotlin_study.repository.CommentRepository
import com.study.kotlin_study.service.impl.CommentService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository

) : CommentService {

    private fun toDTO(com: Comment, member: Member, board: Board): CommentDTO {

        return CommentDTO(
            commentId = com.id,
            writer = member.nickname,
            boardId = board.id,
            comment = com.comment,
            createTime = com.createTime,
            updateTime = com.updateTime
        )
    }
    override fun createComment(commentRequest: CommentRequest, member: Member, board: Board): CommentDTO {
        val comment = Comment(
            comment = commentRequest.content,
            memberId = member.id,
            boardId = board.id,
            createTime = LocalDateTime.now(),
            updateTime = null
        )

        val result = commentRepository.save(comment)

        return toDTO(result, member, board)
    }

    override fun getComment(boardId: Long): List<CommentDTO> {
        TODO("Not yet implemented")
    }

    override fun modifyComment(commentId: Long, commentRequest: CommentRequest, member: Member) {
        TODO("Not yet implemented")
    }

    override fun deleteComment(commentId: Long, member: Member) {
        TODO("Not yet implemented")
    }

}