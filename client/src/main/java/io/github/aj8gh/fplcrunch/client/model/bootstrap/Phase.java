package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record Phase(
    int id,
    String name,
    int startEvent,
    int stopEvent
) {

}
