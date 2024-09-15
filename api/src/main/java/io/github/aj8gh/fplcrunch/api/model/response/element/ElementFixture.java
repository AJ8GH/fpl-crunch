package io.github.aj8gh.fplcrunch.api.model.response.element;

import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementFixture(
    Integer id,
    Integer code,
    Integer teamHome,
    Integer teamHomeScore,
    Integer teamAway,
    Integer teamAwayScore,
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
