package io.github.aj8gh.fplcrunch.client.model.response.myteam;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FplTeam(
    List<TeamPick> picks,
    Instant picksLastUpdated,
    List<TeamChip> chips,
    TeamTransfers transfers
) {

}
