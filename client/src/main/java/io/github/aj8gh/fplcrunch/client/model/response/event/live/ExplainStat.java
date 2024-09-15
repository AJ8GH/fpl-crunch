package io.github.aj8gh.fplcrunch.client.model.response.event.live;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ExplainStat(
    String identifier,
    Integer points,
    Integer value
) {

}
