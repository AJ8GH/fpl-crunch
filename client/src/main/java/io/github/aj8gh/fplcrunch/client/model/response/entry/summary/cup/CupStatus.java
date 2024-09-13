package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.cup;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record CupStatus(
    String qualificationEvent,
    String qualificationNumbers,
    String qualificationRank,
    String qualificationState
) {

}
