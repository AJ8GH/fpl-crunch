package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.league;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ClassicLeague(
    Integer id,
    String name,
    String shortName,
    Instant created,
    Boolean closed,
    Integer rank,
    Integer maxEntries,
    String leagueType,
    String scoring,
    String adminEntry,
    Integer startEvent,
    Boolean entryCanLeave,
    Boolean entryCanAdmin,
    Boolean entryCanInvite,
    Boolean hasCup,
    Integer cupLeague,
    Boolean cupQualified,
    Integer rankCount,
    Integer entryPercentileRank,
    List<ActivePhase> activePhases,
    Integer entryRank,
    Integer entryLastRank
) {

}
