package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record ChipPlay(
    String chipName,
    Integer numPlayed
) {

}
