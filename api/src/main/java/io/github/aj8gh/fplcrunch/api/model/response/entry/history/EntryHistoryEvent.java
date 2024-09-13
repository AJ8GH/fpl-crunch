package io.github.aj8gh.fplcrunch.api.model.response.entry.history;

import lombok.Builder;

@Builder(toBuilder = true)
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
