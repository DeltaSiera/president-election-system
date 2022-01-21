package com.example.electionsystem.mapper

import com.example.electionsystem.dto.CandidateDto
import com.example.electionsystem.dto.RegionDto
import com.example.electionsystem.dto.VoteDto
import com.example.electionsystem.model.Candidate
import com.example.electionsystem.service.CandidateStats
import org.springframework.stereotype.Component

typealias RegionStats = Map<String, CandidateStats>

@Component
class Mapper {
    companion object {
        fun mapToCandidateDto(candidate: Candidate): CandidateDto =
            CandidateDto(candidate.Id, name = "${candidate.firstName} ${candidate.lastName}", candidate.agenda)

        fun mapToRegionDto(regionVotes: RegionStats): List<RegionDto> =
            regionVotes.map { (region, votes) ->
                RegionDto(
                    region,
                    votes.map { (candidate, count) -> VoteDto(mapToCandidateDto(candidate), count) })
            }
    }
}