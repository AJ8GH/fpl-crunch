package io.github.aj8gh.fplcrunch.client.model.response.entry.pick;

import lombok.Builder;

@Builder(toBuilder = true)
public record EntryPickHistory(
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
