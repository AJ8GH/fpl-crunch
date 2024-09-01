package io.github.aj8gh.fplcrunch.client.model.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
