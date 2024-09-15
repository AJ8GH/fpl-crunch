package io.github.aj8gh.fplcrunch.api.model.response.bootstrap;

import io.github.aj8gh.fplcrunch.api.model.response.event.EventResponse;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record BootstrapResponse(
    List<EventResponse> events,
    GameSettings gameSettings,
    List<Phase> phases,
    List<Team> teams,
    Integer totalPlayers,
    List<Element> elements,
    List<ElementStat> elementStats,
    List<ElementType> elementTypes
) {

}
