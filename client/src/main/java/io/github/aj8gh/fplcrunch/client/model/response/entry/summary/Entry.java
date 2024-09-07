package io.github.aj8gh.fplcrunch.client.model.response.entry.summary;

import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.league.Leagues;
import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Entry(
    Integer id,
    Instant joinedTime,
    Integer startedEvent,
    String favouriteTeam,
    String playerFirstName,
    String playerLastName,
    Integer playerRegionId,
    String playerRegionName,
    String playerRegionIsoCodeShort,
    String playerRegionIsoCodeLong,
    Integer yearsActive,
    Integer summaryOverallPoints,
    Integer summaryOverallRank,
    Integer summaryEventPoints,
    Integer summaryEventRank,
    Integer currentEvent,
    Leagues leagues,
    String name,
    Boolean nameChangeBlocked,
    List<Integer> enteredEvents,
    String kit,
    Integer lastDeadlineBank,
    Integer lastDeadlineValue,
    Integer lastDeadlineTotalTransfers
) {

}
