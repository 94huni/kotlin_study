package com.study.kotlin_study.controller

import com.study.kotlin_study.dto.request.CommentRequest
import com.study.kotlin_study.dto.response.CommentDTO
import com.study.kotlin_study.entity.Comment
import com.study.kotlin_study.service.impl.BoardService
import com.study.kotlin_study.service.impl.CommentService
import com.study.kotlin_study.service.impl.MemberService
import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/comment")
class CommentController (
    private val commentService: CommentService,
    private val memberService: MemberService,
    private val boardService: BoardService
    ){

    @PostMapping("{boardId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createComment(session: HttpSession,
                      @PathVariable boardId: Long,
                      @RequestBody commentRequest: CommentRequest): CommentDTO {
        val member = memberService.findMember(session.getAttribute("Member").toString())
        val board = boardService.getBoardEntity(boardId)

        return commentService.createComment(commentRequest, member, board)
    }

    @GetMapping("/{boardId}")
    fun getComments (@PathVariable boardId: Long) : MutableIterable<Comment> {
        return commentService.getComment(boardId)
    }
}