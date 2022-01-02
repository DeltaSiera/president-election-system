package com.example.electionsystem.repository

import com.example.electionsystem.model.Candidate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateRepo : JpaRepository<Candidate, Int>