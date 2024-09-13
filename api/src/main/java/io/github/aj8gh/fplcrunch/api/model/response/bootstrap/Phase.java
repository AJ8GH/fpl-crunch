package io.github.aj8gh.fplcrunch.api.model.response.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record Phase(
    Integer id,
    String name,
    Integer startEvent,
    Integer stopEvent
) {

}
