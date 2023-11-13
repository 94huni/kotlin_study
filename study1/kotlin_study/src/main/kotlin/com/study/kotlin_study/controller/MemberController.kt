package com.study.kotlin_study.controller

import com.study.kotlin_study.dto.request.LoginRequest
import com.study.kotlin_study.dto.request.SignUpRequest
import com.study.kotlin_study.service.MemberService
import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class MemberEmail(
    private val memberService: MemberService
) {
    @PostMapping("/login")
    fun login(loginRequest: LoginRequest, session: HttpSession): String {
        val result: String = memberService.login(loginRequest)

        session.setAttribute("Member", result)

        return result
    }

    @PostMapping("/sign-up")
    fun signUp(signUpRequest: SignUpRequest): String {
        return memberService.signUp(signUpRequest)
    }
}