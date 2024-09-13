package io.github.aj8gh.fplcrunch.client.model.response.entry.pick;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Pick(
    Integer element,
    Integer position,
    Integer multiplier,
    Boolean isCaptain,
    Boolean isViceCaptain
) {

}
