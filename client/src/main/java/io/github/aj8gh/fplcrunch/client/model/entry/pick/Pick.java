package io.github.aj8gh.fplcrunch.client.model.entry.pick;

public record Pick(
    Integer element,
    Integer position,
    Integer multiplier,
    Boolean isCaptain,
    Boolean isViceCaptain
) {

}
