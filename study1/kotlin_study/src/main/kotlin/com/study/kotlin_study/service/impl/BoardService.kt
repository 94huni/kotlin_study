package com.study.kotlin_study.service.impl

import com.study.kotlin_study.dto.request.BoardCreateRequest
import com.study.kotlin_study.dto.response.BoardDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.entity.Member
import org.springframework.data.domain.Page

interface BoardService {
    fun getBoard(boardId: Long): BoardDTO

    fun getBoardEntity(boardId: Long): Board

    fun getBoardPage(page:Int, keyword:String?): Page<BoardDTO>

    fun createBoard(request: BoardCreateRequest, member: Member): BoardDTO

    fun modifyBoard(request: BoardCreateRequest, boardId: Long , member: Member)

    fun deleteBoard(board: Board, member: Member)
}