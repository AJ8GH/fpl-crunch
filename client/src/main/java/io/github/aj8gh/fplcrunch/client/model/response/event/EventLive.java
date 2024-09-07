package io.github.aj8gh.fplcrunch.client.model.response.event;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EventLive(
    List<EventElement> elements
) {

}
