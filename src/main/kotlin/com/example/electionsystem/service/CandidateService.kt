package com.example.electionsystem.service

import com.example.electionsystem.dto.CandidateDto
import com.example.electionsystem.mapper.Mapper.Companion.mapToCandidateDto
import com.example.electionsystem.model.Candidate
import com.example.electionsystem.repository.CandidateRepo
import com.example.electionsystem.repository.VoteRepo
import org.springframework.stereotype.Service

private const val CANDIDATES_TO_SECOND_TOUR = 2

private const val FIRST_AND_SECOND_PLACE = 2

private const val ONE_HUNDRED = 100

private const val VOTES_HALF = 50.0f

private const val FIRST_PLACE_VOTES_AMOUNT = 0

private const val SECOND_PLACE_WINNER_AMOUNT = 1

private const val FIRST_PLACE_WINNER_AMOUNT = 1

private const val SECOND_PLACE_VOTES_AMOUNT = 1


typealias CandidateStats = Map<Candidate, Int>

typealias FirstSecondPlaceVotes = Pair<Int, Int>

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

    fun findWinningCandidates(candidates: CandidateStats): List<Candidate> {
        with(findMaxVotes(candidates)) {
            val firstPlaceWinners = findPlaceWinnersByVotes(candidates, first)
            val secondPlaceWinners = findPlaceWinnersByVotes(candidates, this.second)
            val (isWinner, winnerCandidate) = firstTourWinner(candidates)
            return when {
                isWinner -> {
                    winnerCandidate
                }
                tieByMaxVotes(firstPlaceWinners) -> {
                    firstPlaceWinners
                }
                tieByDifferentVotes(firstPlaceWinners, secondPlaceWinners) -> {
                    firstPlaceWinners + secondPlaceWinners
                }
                else -> {
                    throw IllegalStateException("There are no clear winner. New elections has to be started!")
                }
            }
        }

    }

    fun findMaxVotes(candidates: CandidateStats): FirstSecondPlaceVotes =
        candidates.map { it.value }
                .distinct()
                .sortedDescending()
                .take(FIRST_AND_SECOND_PLACE)
                .let { it[FIRST_PLACE_VOTES_AMOUNT] to it[SECOND_PLACE_VOTES_AMOUNT] }

    private fun firstTourWinner(candidates: CandidateStats): Pair<Boolean, List<Candidate>> {
        val totalVotes = getTotalVotes(candidates)
        candidates.forEach { (candidate, votes) ->
            val voteShare = calcVoteShare(votes, totalVotes.toDouble())
            if (voteShare > VOTES_HALF) {
                return true to listOf(candidate)
            }
        }
        return false to emptyList()
    }

    private fun tieByDifferentVotes(
        firstPlaceWinners: List<Candidate>,
        secondPlaceWinners: List<Candidate>,
    ): Boolean =
        firstPlaceWinners.size == FIRST_PLACE_WINNER_AMOUNT && secondPlaceWinners.size == SECOND_PLACE_WINNER_AMOUNT

    private fun findPlaceWinnersByVotes(candidates: CandidateStats, votes: Int): List<Candidate> =
        candidates.filter { it.value == votes }
                .map { it.key }

    private fun getTotalVotes(candidates: CandidateStats): Int =
        candidates.map { it.value }
                .sum()

    private fun tieByMaxVotes(firstPlaceWinners: List<Candidate>): Boolean =
        firstPlaceWinners.size == CANDIDATES_TO_SECOND_TOUR

    fun calcVoteShare(votes: Int, totalVotes: Double): Double = ((votes / totalVotes) * ONE_HUNDRED)
}