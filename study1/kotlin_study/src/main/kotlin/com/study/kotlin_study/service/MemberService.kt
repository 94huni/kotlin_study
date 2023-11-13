package com.study.kotlin_study.service

import com.study.kotlin_study.dto.request.LoginRequest
import com.study.kotlin_study.dto.request.SignUpRequest
import com.study.kotlin_study.entity.Member
import com.study.kotlin_study.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
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

    fun signUp(signUpRequest: SignUpRequest): String {
        if(signUpRequest.password != signUpRequest.validPassword) throw RuntimeException("비밀 번호 불일치")

        if(memberRepository.existsByEmail(signUpRequest.email)) throw RuntimeException("이미 사용 중인 이메일")

        val member = Member(
            email = signUpRequest.email,
            name = signUpRequest.name,
            nickname = signUpRequest.nickname,
            password = signUpRequest.password,
            phone = signUpRequest.phone
        )

        memberRepository.save(member)

        return "회원 가입 성공"
    }
}