package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.league;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
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
