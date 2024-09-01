package io.github.aj8gh.fplcrunch.client.model.entry.cup;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Cup(
    List<CupMatch> matches,
    CupStatus status,
    String cupLeague
) {

}
