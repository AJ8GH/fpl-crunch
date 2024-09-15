package io.github.aj8gh.fplcrunch.api.model.response.event.live;

import lombok.Builder;

@Builder(toBuilder = true)
public record ExplainStat(
    String identifier,
    Integer points,
    Integer value
) {

}
