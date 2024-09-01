package io.github.aj8gh.fplcrunch.client.model.element;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementFixture(
    Integer id,
    Integer code,
    @JsonAlias("teamH") Integer teamHome,
    @JsonAlias("teamHScore") Integer teamHomeScore,
    @JsonAlias("teamA") Integer teamAway,
    @JsonAlias("teamAScore") Integer teamAwayScore,
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
