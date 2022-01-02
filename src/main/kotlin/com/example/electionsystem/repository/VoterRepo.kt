package com.example.electionsystem.repository

import com.example.electionsystem.model.Voter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoterRepo : JpaRepository<Voter, Int>