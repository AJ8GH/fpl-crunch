package io.github.aj8gh.fplcrunch.client.model.league.classic;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ClassicLeagueStandings(
    NewEntries newEntries,
    @JsonAlias("lastUpdatedData") Instant lastUpdatedDate,
    ClassicLeagueStandingsLeague classicLeague,
    Standings standings
) {

}
