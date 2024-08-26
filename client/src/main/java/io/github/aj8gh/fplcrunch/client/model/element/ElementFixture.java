package io.github.aj8gh.fplcrunch.client.model.element;

import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementFixture(
    int id,
    int code,
    int teamH,
    Integer teamHScore,
    int teamA,
    Integer teamAScore,
    int event,
    boolean finished,
    int minutes,
    boolean provisionalStartTime,
    Instant kickoffTime,
    String eventName,
    boolean isHome,
    int difficulty
) {

}
