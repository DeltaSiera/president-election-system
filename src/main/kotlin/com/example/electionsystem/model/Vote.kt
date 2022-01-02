package com.example.electionsystem.model

import javax.persistence.*

private const val DEFAULT_ID = 1

@Entity
@Table(name = "Votes")
data class Vote(
    @Id @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bulletinId: Int = DEFAULT_ID,
    @OneToOne(cascade = [CascadeType.ALL])
    var voter: Voter,
    @ManyToOne(cascade = [CascadeType.ALL])
    var candidate: Candidate,
)
