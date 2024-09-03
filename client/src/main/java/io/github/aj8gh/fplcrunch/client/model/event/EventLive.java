package io.github.aj8gh.fplcrunch.client.model.event;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EventLive(
    List<EventElement> elements
) {

}
