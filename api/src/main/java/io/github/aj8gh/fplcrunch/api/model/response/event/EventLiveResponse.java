package io.github.aj8gh.fplcrunch.api.model.response.event;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EventLiveResponse(
    List<EventElement> elements
) {

}
