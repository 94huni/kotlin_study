package com.study.kotlin_study.dto.request

data class SignUpRequest(
    val name: String?,
    val nickname: String?,
    val email: String?,
    val phone: String?,
    val password: String?,
    val validPassword: String?
)