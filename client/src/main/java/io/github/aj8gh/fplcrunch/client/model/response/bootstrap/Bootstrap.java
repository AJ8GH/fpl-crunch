package io.github.aj8gh.fplcrunch.client.model.response.bootstrap;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.aj8gh.fplcrunch.client.model.response.event.Event;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Bootstrap(
    List<Event> events,
    GameSettings gameSettings,
    List<Phase> phases,
    List<Team> teams,
    Integer totalPlayers,
    List<Element> elements,
    List<ElementStat> elementStats,
    List<ElementType> elementTypes
) {

}
