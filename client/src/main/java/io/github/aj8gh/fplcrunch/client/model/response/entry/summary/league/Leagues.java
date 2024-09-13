package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.league;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.cup.Cup;
import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.cup.CupMatch;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Leagues(
    List<ClassicLeague> classic,
    List<?> h2h,
    Cup cup,
    List<CupMatch> cupMatches
) {

}
