package io.github.aj8gh.fplcrunch.api.model.response.entry.summary.league;

import io.github.aj8gh.fplcrunch.api.model.response.entry.summary.cup.Cup;
import io.github.aj8gh.fplcrunch.api.model.response.entry.summary.cup.CupMatch;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Leagues(
    List<ClassicLeague> classic,
    List<?> h2h,
    Cup cup,
    List<CupMatch> cupMatches
) {

}
