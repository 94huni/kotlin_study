package com.study.kotlin_study.service.impl

import com.study.kotlin_study.dto.request.LoginRequest
import com.study.kotlin_study.dto.request.SignUpRequest
import com.study.kotlin_study.entity.Member

interface MemberService {
    fun login(loginRequest: LoginRequest): String

    fun signUp(signUpRequest: SignUpRequest): String

    fun findMember(email: String): Member
}