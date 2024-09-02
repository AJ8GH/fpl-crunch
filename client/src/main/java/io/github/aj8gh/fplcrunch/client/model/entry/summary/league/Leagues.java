package io.github.aj8gh.fplcrunch.client.model.entry.summary.league;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.aj8gh.fplcrunch.client.model.entry.summary.cup.Cup;
import io.github.aj8gh.fplcrunch.client.model.entry.summary.cup.CupMatch;
import java.util.List;
import lombok.Builder;

@Builder
public record Leagues(
    List<ClassicLeague> classic,
    @JsonIgnore List<HeadToHeadLeague> h2h,
    Cup cup,
    List<CupMatch> cupMatches
) {

}
