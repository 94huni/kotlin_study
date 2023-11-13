package com.study.kotlin_study.repository

import com.study.kotlin_study.entity.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository : CrudRepository<Board, Long> {

}