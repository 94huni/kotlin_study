package com.study.kotlin_study.service.impl

import com.study.kotlin_study.dto.request.CommentRequest
import com.study.kotlin_study.dto.response.CommentDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.entity.Comment
import com.study.kotlin_study.entity.Member

interface CommentService {
    fun createComment(commentRequest: CommentRequest, member: Member, board: Board): CommentDTO

    fun getComment(boardId: Long): List<CommentDTO>

    fun modifyComment(commentId: Long, commentRequest: CommentRequest, member: Member)

    fun deleteComment(commentId: Long, member: Member)
}