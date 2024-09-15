package io.github.aj8gh.fplcrunch.api.model.response.fixture;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FixtureResponse(
    Integer code,
    Integer event,
    Boolean finished,
    Boolean finishedProvisional,
    Integer id,
    Instant kickoffTime,
    Integer minutes,
    Boolean provisionalStartTime,
    Boolean started,
    Integer teamAway,
    Integer teamAwayScore,
    Integer teamHome,
    Integer teamHomeScore,
    List<FixtureStat> stats,
    Integer teamHomeDifficulty,
    Integer teamAwayDifficulty,
    Integer pulseId
) {

}
