package io.github.aj8gh.fplcrunch.api.model.response.league.classic;

import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ClassicLeagueStandingsResponse(
    NewEntries newEntries,
    Instant lastUpdatedDate,
    ClassicLeagueStandingsLeague league,
    Standings standings
) {

}
