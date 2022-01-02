package com.example.electionsystem.model

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table(name = "Voters")
data class Voter(
    @Id @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Int,
    @Column @NotNull
    @Enumerated(EnumType.STRING)
    val region: Region,
)
