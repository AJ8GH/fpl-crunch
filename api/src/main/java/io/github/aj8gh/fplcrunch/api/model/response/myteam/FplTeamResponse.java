package io.github.aj8gh.fplcrunch.api.model.response.myteam;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FplTeamResponse(
    List<TeamPick> picks,
    Instant picksLastUpdated,
    List<TeamChip> chips,
    TeamTransfers transfers
) {

}
