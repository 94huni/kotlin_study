package com.study.kotlin_study.controller

import com.study.kotlin_study.dto.request.LoginRequest
import com.study.kotlin_study.dto.request.SignUpRequest
import com.study.kotlin_study.service.MemberServiceImpl
import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class MemberController(
    private val memberService: MemberServiceImpl
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest, session: HttpSession): String {
        val result: String = memberService.login(loginRequest)

        session.setAttribute("Member", result)

        return "$result 로그인 성공"
    }

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): String {
        return memberService.signUp(signUpRequest)
    }

}