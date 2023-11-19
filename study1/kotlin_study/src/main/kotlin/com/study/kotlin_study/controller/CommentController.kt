package com.study.kotlin_study.controller

import com.study.kotlin_study.dto.request.CommentRequest
import com.study.kotlin_study.dto.response.CommentDTO
import com.study.kotlin_study.entity.Comment
import com.study.kotlin_study.service.impl.BoardService
import com.study.kotlin_study.service.impl.CommentService
import com.study.kotlin_study.service.impl.MemberService
import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @PostMapping("/{boardId}")
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

    @PutMapping("/{commentId}")
    fun modifyComment(@PathVariable commentId: Long,
                      @RequestBody request: CommentRequest,
                      session: HttpSession): String {
        val member = memberService.findMember(session.getAttribute("Member").toString())

        commentService.modifyComment(commentId, request, member)

        return "${member.nickname} 작성 댓글이 수정 됐습니다."
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long, session: HttpSession): String {
        val member = memberService.findMember(session.getAttribute("Member").toString())

        commentService.deleteComment(commentId, member)

        return "${member.nickname} 작석 댓글이 삭제 됐습니다."
    }
}