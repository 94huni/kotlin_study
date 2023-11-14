package com.study.kotlin_study.repository

import com.study.kotlin_study.entity.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment, Long> {
    fun findAllByOrderByIdDesc(pageable: Pageable) : Page<Comment>

    fun findByBoardIdOrderByIdDesc(boardId: Long) : MutableIterable<Comment>
}