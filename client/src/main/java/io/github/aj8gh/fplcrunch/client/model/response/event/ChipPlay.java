package io.github.aj8gh.fplcrunch.client.model.response.event;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ChipPlay(
    String chipName,
    Integer numPlayed
) {

}
