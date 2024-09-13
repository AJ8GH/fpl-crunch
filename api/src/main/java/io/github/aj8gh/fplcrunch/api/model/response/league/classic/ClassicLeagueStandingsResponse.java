package io.github.aj8gh.fplcrunch.api.model.response.league.classic;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ClassicLeagueStandingsResponse(
    NewEntries newEntries,
    @JsonAlias("lastUpdatedData") Instant lastUpdatedDate,
    ClassicLeagueStandingsLeague league,
    Standings standings
) {

}
