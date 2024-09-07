package io.github.aj8gh.fplcrunch.client.model.response.league.classic;

import lombok.Builder;

@Builder(toBuilder = true)
public record Result(
    Integer id,
    Integer eventTotal,
    String playerName,
    Integer rank,
    Integer lastRank,
    Integer rankSort,
    Integer total,
    Integer entry,
    String entryName
) {

}
