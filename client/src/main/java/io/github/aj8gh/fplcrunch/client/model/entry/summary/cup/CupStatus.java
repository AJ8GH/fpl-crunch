package io.github.aj8gh.fplcrunch.client.model.entry.summary.cup;

import lombok.Builder;

@Builder(toBuilder = true)
public record CupStatus(
    String qualificationEvent,
    String qualificationNumbers,
    String qualificationRank,
    String qualificationState
) {

}
