package com.example.electionsystem.service

import com.example.electionsystem.dto.RegionDto
import com.example.electionsystem.dto.VoteDto
import com.example.electionsystem.dto.VoteReqDto
import com.example.electionsystem.mapper.Mapper.Companion.mapToCandidateDto
import com.example.electionsystem.mapper.Mapper.Companion.mapToRegionDto
import com.example.electionsystem.model.Candidate
import com.example.electionsystem.model.Vote
import com.example.electionsystem.model.Voter
import com.example.electionsystem.repository.CandidateRepo
import com.example.electionsystem.repository.VoteRepo
import com.example.electionsystem.repository.VoterRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class VoteService(
    val candidateRepo: CandidateRepo,
    val voterRepo: VoterRepo,
    val voteRepo: VoteRepo,
) {
    fun registerVote(voteReq: VoteReqDto) {
        val voter = findVoter(voteReq.Id)
        val candidate = checkCandidateRegistration(voteReq.candidateNumber)
        checkIfVoteIsPresent(voter)
        voteRepo.save(Vote(voter = voter, candidate = candidate))
    }

    fun findVoter(voterId: Int): Voter {
        return voterRepo.findByIdOrNull(voterId)
            ?: throw NoSuchElementException("Voter $voterId does not exist!")
    }

    fun checkCandidateRegistration(candidateNumber: Int): Candidate {
        return candidateRepo.findByIdOrNull(candidateNumber)
            ?: throw NoSuchElementException("Candidate $candidateNumber does not exist!")
    }

    fun checkIfVoteIsPresent(voter: Voter) {
        require(voteRepo.findByVoter(voter) == null) { "${voter.Id} have already voted for another candidate!" }
    }


    fun countVotesPerRegion(): List<RegionDto> =
        voteRepo.findAll()
                .groupBy { vote -> groupByRegion(vote) }
                .mapValues { (_, votes) -> groupVotesByCandidate(votes) }
                .let(::mapToRegionDto)


    private fun groupByRegion(vote: Vote): String = vote.voter.region.name

    private fun groupVotesByCandidate(votes: List<Vote>): Map<Candidate, Int> =
        votes.groupingBy { it.candidate }
                .eachCount()


    fun countVotesPerCandidate(): List<VoteDto> =
        candidateRepo.findAll()
                .map { VoteDto(mapToCandidateDto(it), countCandidateVotes(it)) }

    fun countCandidateVotes(candidate: Candidate): Int = voteRepo.countVotesByCandidate(candidate)

}


