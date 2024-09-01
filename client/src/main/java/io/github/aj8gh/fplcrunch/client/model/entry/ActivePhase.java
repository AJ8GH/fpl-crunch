package io.github.aj8gh.fplcrunch.client.model.entry;

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
