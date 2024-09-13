package io.github.aj8gh.fplcrunch.api.model.response.fixture;

import com.fasterxml.jackson.annotation.JsonAlias;
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
    @JsonAlias("teamA") Integer teamAway,
    @JsonAlias("teamAScore") Integer teamAwayScore,
    @JsonAlias("teamH") Integer teamHome,
    @JsonAlias("teamHScore") Integer teamHomeScore,
    List<FixtureStat> stats,
    @JsonAlias("teamHDifficulty") Integer teamHomeDifficulty,
    @JsonAlias("teamADifficulty") Integer teamAwayDifficulty,
    Integer pulseId
) {

}
