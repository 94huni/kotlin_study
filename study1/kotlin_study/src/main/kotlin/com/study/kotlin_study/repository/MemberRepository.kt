package com.study.kotlin_study.repository

import com.study.kotlin_study.entity.Member
import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, Long>{

    fun findById(id: Long?): Member
    fun findByEmail(email: String): Member

    fun existsByEmail(email: String?): Boolean
}