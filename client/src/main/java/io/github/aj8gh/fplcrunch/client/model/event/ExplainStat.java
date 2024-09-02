package io.github.aj8gh.fplcrunch.client.model.event;

import lombok.Builder;

@Builder(toBuilder = true)
public record ExplainStat(
    String identifier,
    Integer points,
    Integer value
) {

}
