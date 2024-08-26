package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Bootstrap(
    List<Event> events,
    GameSettings gameSettings,
    List<Phase> phases,
    List<Team> teams,
    int totalPlayers,
    List<Element> elements,
    List<ElementStat> elementStats,
    List<ElementType> elementTypes
) {

}
