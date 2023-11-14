package com.study.kotlin_study.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val comment: String?,

    @Column
    val memberId: Long?,

    val createTime: LocalDateTime?,

    val updateTime: LocalDateTime?
)