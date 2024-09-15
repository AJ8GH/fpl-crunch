package io.github.aj8gh.fplcrunch.api.model.response.event;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EventResponse(
    Integer id,
    String name,
    Instant deadlineTime,
    Instant releaseTime,
    Integer averageEntryScore,
    Boolean finished,
    Boolean dataChecked,
    Integer highestScoringEntry,
    Integer deadlineTimeEpoch,
    Integer deadlineTimeGameOffset,
    Integer highestScore,
    Boolean isPrevious,
    Boolean isCurrent,
    Boolean isNext,
    Boolean cupLeaguesCreated,
    Boolean headToHeadKoMatchesCreated,
    Integer rankedCount,
    List<ChipPlay> chipPlays,
    Integer mostSelected,
    Integer mostTransferredIn,
    Integer topElement,
    TopElementInfo topElementInfo,
    Integer transfersMade,
    Integer mostCaptained,
    Integer mostViceCaptained
) {

}
