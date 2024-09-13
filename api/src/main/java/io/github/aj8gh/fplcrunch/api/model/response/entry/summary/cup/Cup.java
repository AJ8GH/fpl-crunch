package io.github.aj8gh.fplcrunch.api.model.response.entry.summary.cup;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Cup(
    List<CupMatch> matches,
    CupStatus status,
    String cupLeague
) {

}
