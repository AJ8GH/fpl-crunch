package io.github.aj8gh.fplcrunch.client.model.response.myteam;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record TeamChip(
    String statusForEntry,
    List<?> playedByEntry,
    String name,
    Integer number,
    Integer startEvent,
    Integer stopEvent,
    String chipType,
    Boolean isPending
) {

}
