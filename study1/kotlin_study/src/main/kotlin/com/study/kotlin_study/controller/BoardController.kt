package com.study.kotlin_study.controller

import com.study.kotlin_study.service.impl.BoardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/board")
class BoardController (
    private val boardService: BoardService
){
    @GetMapping("/{boardId}")
    fun getBoard(@PathVariable boardId: Long) {
        return
    }
}