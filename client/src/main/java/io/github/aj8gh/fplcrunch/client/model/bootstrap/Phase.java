package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record Phase(
    Integer id,
    String name,
    Integer startEvent,
    Integer stopEvent
) {

}
