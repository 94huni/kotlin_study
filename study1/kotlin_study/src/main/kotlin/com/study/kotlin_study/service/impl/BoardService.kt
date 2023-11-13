package com.study.kotlin_study.service.impl

import com.study.kotlin_study.dto.request.BoardCreateRequest
import com.study.kotlin_study.dto.response.BoardDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.entity.Member

interface BoardService {
    fun getBoard(boardId: Long): BoardDTO

    fun createBoard(request: BoardCreateRequest, member: Member): BoardDTO
}