package com.study.kotlin_study.controller

import com.study.kotlin_study.dto.request.LoginRequest
import com.study.kotlin_study.service.MemberService
import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.PostMapping

class MemberEmail(
    private val memberService: MemberService
) {
    @PostMapping("/login")
    fun login(loginRequest: LoginRequest, session: HttpSession): String {
        val result: String = memberService.login(loginRequest)

        session.setAttribute("Member", result)

        return result
    }
}