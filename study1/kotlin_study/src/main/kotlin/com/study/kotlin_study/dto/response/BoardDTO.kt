package com.study.kotlin_study.dto.response

import java.time.LocalDateTime

data class BoardDTO(
    val boardId: Long?,
    val title: String?,
    val content: String?,
    val writer: String,
    val createTime: LocalDateTime,
    val updateTime: LocalDateTime?
)