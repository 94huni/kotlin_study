package com.study.kotlin_study.dto.response

import java.time.LocalDateTime

data class CommentDTO(
    val commentId: Long?,
    val comment: String?,
    val writer: String?,
    val boardId: Long?,
    val createTime: LocalDateTime?,
    val updateTime: LocalDateTime?
)