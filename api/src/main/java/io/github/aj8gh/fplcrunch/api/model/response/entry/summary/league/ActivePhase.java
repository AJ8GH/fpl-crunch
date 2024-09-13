package io.github.aj8gh.fplcrunch.api.model.response.entry.summary.league;

import lombok.Builder;

@Builder(toBuilder = true)
public record ActivePhase(
    Integer phase,
    Integer rank,
    Integer lastRank,
    Integer rankSort,
    Integer total,
    Integer leagueId,
    Integer rankCount,
    Integer entryPercentileRank
) {

}
