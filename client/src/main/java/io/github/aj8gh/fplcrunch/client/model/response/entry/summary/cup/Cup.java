package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.cup;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Cup(
    List<CupMatch> matches,
    CupStatus status,
    String cupLeague
) {

}
