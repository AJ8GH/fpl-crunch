package io.github.aj8gh.fplcrunch.api.model.response.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record ChipPlay(
    String chipName,
    Integer numPlayed
) {

}
