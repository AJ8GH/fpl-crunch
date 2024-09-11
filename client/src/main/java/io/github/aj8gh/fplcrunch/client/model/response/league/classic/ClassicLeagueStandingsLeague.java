package io.github.aj8gh.fplcrunch.client.model.response.league.classic;

import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ClassicLeagueStandingsLeague(
    Integer id,
    String name,
    Instant created,
    Boolean closed,
    Integer maxEntries,
    String leagueType,
    String scoring,
    Integer adminEntry,
    Integer startEvent,
    String codePrivacy,
    Boolean hasCup,
    Boolean cupLeague,
    Integer rank
) {

}
