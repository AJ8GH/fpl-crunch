package io.github.aj8gh.fplcrunch.client.model.response.entry.history;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record EntryHistoryEvent(
    Integer event,
    Integer points,
    Integer totalPoints,
    Integer rank,
    Integer rankSort,
    Integer overallRank,
    Integer percentileRank,
    Integer bank,
    Integer value,
    Integer eventTransfers,
    Integer eventTransfersCost,
    Integer pointsOnBench
) {

}
