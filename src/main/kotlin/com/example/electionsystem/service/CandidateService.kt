package com.example.electionsystem.service

import com.example.electionsystem.dto.CandidateDto
import com.example.electionsystem.mapper.Mapper.Companion.mapToCandidateDto
import com.example.electionsystem.model.Candidate
import com.example.electionsystem.repository.CandidateRepo
import com.example.electionsystem.repository.VoteRepo
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

private const val MOST_VOTED_CANDIDATES_AMOUNT = 2

private const val ONE_HUNDRED = 100

private const val VOTES_HALF = 50.0f

@Service
class CandidateService(
    val candidateRepo: CandidateRepo,
    val voteRepo: VoteRepo,
) {
    fun fetchAllCandidates(): List<CandidateDto> =
        candidateRepo.findAll()
                .map(::mapToCandidateDto)


    fun getWiningCandidates(): List<CandidateDto> =
        voteRepo.findAll()
                .groupingBy { it.candidate }
                .eachCount()
                .let(::findWinningCandidates)
                .map(::mapToCandidateDto)

    fun findWinningCandidates(candidates: Map<Candidate, Int>): List<Candidate> {
        val maxVotes = getHighestNumberOfVotes(candidates)
        val totalVotes = getTotalVotes(candidates)

        candidates.forEach { (candidate, votes) ->
            val voteShare = calcVoteShare(votes, totalVotes)
            if (voteShare > VOTES_HALF) {
                return listOf(candidate)
            }
        }

        val winners = candidates.toList()
                .sortedByDescending { (_, voteCount) -> voteCount }
                .filter { it.second.toDouble() == maxVotes }
                .map { it.first }

        return when {
            winners.size <= MOST_VOTED_CANDIDATES_AMOUNT -> winners
            else -> throw IllegalStateException("There are ${candidates.size} candidates with the same amount of votes!")
        }
    }

    private fun calcVoteShare(votes: Int, totalVotes: Double) = ((votes / totalVotes) * ONE_HUNDRED)

    private fun getHighestNumberOfVotes(candidates: Map<Candidate, Int>): Double =
        candidates.map { it.value.toDouble() }
                .maxOf { it }

    private fun getTotalVotes(candidates: Map<Candidate, Int>): Double =
        candidates.map { it.value.toDouble() }
                .sum()
}