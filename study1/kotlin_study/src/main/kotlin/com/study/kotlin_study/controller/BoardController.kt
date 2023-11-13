package com.study.kotlin_study.controller

import com.study.kotlin_study.dto.request.BoardCreateRequest
import com.study.kotlin_study.dto.response.BoardDTO
import com.study.kotlin_study.entity.Board
import com.study.kotlin_study.entity.Member
import com.study.kotlin_study.service.impl.BoardService
import com.study.kotlin_study.service.impl.MemberService
import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/board")
class BoardController (
    private val boardService: BoardService,
    private val memberService: MemberService
){
    @GetMapping("/{boardId}")
    fun getBoard(@PathVariable boardId: Long): BoardDTO {
        return boardService.getBoard(boardId)
    }

    @PostMapping
    fun createBoard(@RequestBody request: BoardCreateRequest, session: HttpSession): BoardDTO {
        val writer : String = session.getAttribute("Member").toString()
        val member = memberService.findMember(writer)

        return boardService.createBoard(request, member)
    }

    @PutMapping("/{boardId}")
    fun modifyBoard(@PathVariable boardId: Long, @RequestBody request: BoardCreateRequest, session: HttpSession): String {
        val member: Member = memberService.findMember(session.getAttribute("Member").toString())
        boardService.modifyBoard(request, boardId, member)

        return "$boardId 수정 완료"
    }

    @DeleteMapping("/{boardId}")
    fun delete(@PathVariable boardId: Long, session: HttpSession):String {
        val member :Member = memberService.findMember(session.getAttribute("Member").toString())
        val board :Board = boardService.getBoardEntity(boardId)
        boardService.deleteBoard(board, member)

        return "${board.title} 글이 삭제 되었습니다."
    }
}