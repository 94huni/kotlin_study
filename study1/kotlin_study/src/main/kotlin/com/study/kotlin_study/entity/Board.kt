package com.study.kotlin_study.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Board (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 50)
    val title: String?,

    @Column
    val content: String?,

    @Column(name = "m_id")
    val memberId: Long?,

    val createTime: LocalDateTime,

    val updateTime: LocalDateTime? = null
)