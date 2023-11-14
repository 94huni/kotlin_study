package com.study.kotlin_study.repository

import com.study.kotlin_study.entity.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment, Long> {
}