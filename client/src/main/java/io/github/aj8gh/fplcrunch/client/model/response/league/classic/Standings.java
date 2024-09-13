package io.github.aj8gh.fplcrunch.client.model.response.league.classic;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Standings(
    Boolean hasNext,
    Integer page,
    List<Result> results
) {

}
