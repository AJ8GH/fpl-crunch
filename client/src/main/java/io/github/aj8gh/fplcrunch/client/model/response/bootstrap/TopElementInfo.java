package io.github.aj8gh.fplcrunch.client.model.response.bootstrap;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record TopElementInfo(
    Integer id,
    Integer points
) {

}
