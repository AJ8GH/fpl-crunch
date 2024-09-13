package io.github.aj8gh.fplcrunch.client.model.response.league.classic;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
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
