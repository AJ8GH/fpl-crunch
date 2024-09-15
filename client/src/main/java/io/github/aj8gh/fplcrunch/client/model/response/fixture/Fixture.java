package io.github.aj8gh.fplcrunch.client.model.response.fixture;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Fixture(
    Integer code,
    Integer event,
    Boolean finished,
    Boolean finishedProvisional,
    Integer id,
    Instant kickoffTime,
    Integer minutes,
    Boolean provisionalStartTime,
    Boolean started,
    @JsonAlias("team_a") Integer teamAway,
    @JsonAlias("team_a_score") Integer teamAwayScore,
    @JsonAlias("team_h") Integer teamHome,
    @JsonAlias("team_h_score") Integer teamHomeScore,
    List<FixtureStat> stats,
    @JsonAlias("team_h_difficulty") Integer teamHomeDifficulty,
    @JsonAlias("team_a_difficulty") Integer teamAwayDifficulty,
    Integer pulseId
) {

}
