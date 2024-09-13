package io.github.aj8gh.fplcrunch.client.model.response.entry.history;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Season(
    String seasonName,
    Integer totalPoints,
    Integer rank
) {

}
