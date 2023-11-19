package com.study.kotlin_study.repository

import com.study.kotlin_study.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface BoardRepository : CrudRepository<Board, Long> {
    fun findAll(pageable: Pageable): Page<Board>

    fun findByTitleOrderByIdDesc(keyword:String, pageable: Pageable) : Page<Board>
}