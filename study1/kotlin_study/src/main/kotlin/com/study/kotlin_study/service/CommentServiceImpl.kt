package com.study.kotlin_study.service

import com.study.kotlin_study.dto.request.CommentRequest
import com.study.kotlin_study.dto.response.CommentDTO
import com.study.kotlin_study.entity.Member
import com.study.kotlin_study.repository.CommentRepository
import com.study.kotlin_study.service.impl.CommentService
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository

) : CommentService {
    override fun createComment(commentRequest: CommentRequest, member: Member): CommentDTO {
        TODO("Not yet implemented")
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