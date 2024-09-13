package io.github.aj8gh.fplcrunch.api.model.response.entry.pick;

import lombok.Builder;

@Builder(toBuilder = true)
public record Pick(
    Integer element,
    Integer position,
    Integer multiplier,
    Boolean isCaptain,
    Boolean isViceCaptain
) {

}
