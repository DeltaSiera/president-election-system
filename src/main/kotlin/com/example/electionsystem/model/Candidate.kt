package com.example.electionsystem.model

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table(name = "Candidates")
data class Candidate(
    @Id @Column(unique = true)
    val Id: Int,
    @Column @NotNull
    val firstName: String,
    @Column @NotNull
    val lastName: String,
    @Column(unique = true) @NotNull
    val agenda: String
)