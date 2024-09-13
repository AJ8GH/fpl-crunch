package io.github.aj8gh.fplcrunch.api.model.response.event;

import lombok.Builder;

@Builder(toBuilder = true)
public record ExplainStat(
    String identifier,
    Integer points,
    Integer value
) {

}
