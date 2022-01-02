package com.example.electionsystem.repository

import com.example.electionsystem.model.Candidate
import com.example.electionsystem.model.Vote
import com.example.electionsystem.model.Voter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoteRepo : JpaRepository<Vote, Int> {
    fun findByVoter(voter: Voter): Vote?
    fun countVotesByCandidate(candidate: Candidate): Int
}