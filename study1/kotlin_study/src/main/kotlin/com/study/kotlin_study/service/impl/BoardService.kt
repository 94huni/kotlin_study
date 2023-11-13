package com.study.kotlin_study.service.impl

import com.study.kotlin_study.dto.response.BoardDTO
import com.study.kotlin_study.entity.Board

interface BoardService {
    fun getBoard(boardId: Long): BoardDTO
}