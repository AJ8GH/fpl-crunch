package io.github.aj8gh.fplcrunch.client.model.fixture;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Fixture(
    int code,
    int event,
    boolean finished,
    boolean finishedProvisional,
    int id,
    Instant kickoffTime,
    int minutes,
    boolean provisionalStartTime,
    boolean started,
    int teamA,
    int teamAScore,
    int teamH,
    int teamHScore,
    List<FixtureStat> stats,
    int teamHDifficulty,
    int teamADifficulty,
    int pulseId
) {

}
