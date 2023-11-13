package com.study.kotlin_study.service

import com.study.kotlin_study.dto.request.LoginRequest
import com.study.kotlin_study.entity.Member
import com.study.kotlin_study.repository.MemberRepository

class MemberService (
    private val memberRepository: MemberRepository
) {
    fun login(loginRequest: LoginRequest): String {
        val member: Member = memberRepository.findByEmail(loginRequest.email)

        if (member.password != loginRequest.password || member.email == null) {
            throw RuntimeException("아이디 또는 비밀 번호 확인")
        }

        return member.email
    }
}