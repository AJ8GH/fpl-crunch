package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.league;

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
