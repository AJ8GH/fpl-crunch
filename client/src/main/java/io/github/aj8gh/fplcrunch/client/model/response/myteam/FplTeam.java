package io.github.aj8gh.fplcrunch.client.model.response.myteam;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record FplTeam(
    List<TeamPick> picks,
    Instant picksLastUpdated,
    List<TeamChip> chips,
    TeamTransfers transfers
) {

}
