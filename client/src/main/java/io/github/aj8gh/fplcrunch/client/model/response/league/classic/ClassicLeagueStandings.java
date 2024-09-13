package io.github.aj8gh.fplcrunch.client.model.response.league.classic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ClassicLeagueStandings(
    NewEntries newEntries,
    @JsonAlias("lastUpdatedData") Instant lastUpdatedDate,
    ClassicLeagueStandingsLeague league,
    Standings standings
) {

}
