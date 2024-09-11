package io.github.aj8gh.fplcrunch.client.model.response.myteam;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
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
