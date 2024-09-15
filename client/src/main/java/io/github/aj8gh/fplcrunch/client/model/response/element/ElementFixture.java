package io.github.aj8gh.fplcrunch.client.model.response.element;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ElementFixture(
    Integer id,
    Integer code,
    @JsonAlias("team_h") Integer teamHome,
    @JsonAlias("team_h_score") Integer teamHomeScore,
    @JsonAlias("team_a") Integer teamAway,
    @JsonAlias("team_a_score") Integer teamAwayScore,
    Integer event,
    Boolean finished,
    Integer minutes,
    Boolean provisionalStartTime,
    Instant kickoffTime,
    String eventName,
    Boolean isHome,
    Integer difficulty
) {

}
