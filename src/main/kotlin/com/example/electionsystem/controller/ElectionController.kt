package com.example.electionsystem.controller

import com.example.electionsystem.dto.CandidateDto
import com.example.electionsystem.dto.RegionDto
import com.example.electionsystem.dto.VoteDto
import com.example.electionsystem.dto.VoteReqDto
import com.example.electionsystem.model.Candidate
import com.example.electionsystem.service.CandidateService
import com.example.electionsystem.service.VoteService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/elections/candidate"])
class ElectionController(
    val candidateService: CandidateService, val voteService: VoteService,
) {
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    fun getAllCandidates(): List<CandidateDto> = candidateService.fetchAllCandidates()

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = ["/vote"])
    fun takeVoteForCandidate(@RequestBody vote: VoteReqDto) {
        voteService.registerVote(vote)
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = ["/winner"])
    fun getWinners(): List<CandidateDto> = candidateService.getWiningCandidates()

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = ["/votes"])
    fun getVotesDistributionAmongCandidates(): List<VoteDto> =
        voteService.countVotesPerCandidate()

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = ["/votes/regions"])
    fun getVotesDistributionPerRegions(): List<RegionDto> =
        voteService.countVotesPerRegion()

}