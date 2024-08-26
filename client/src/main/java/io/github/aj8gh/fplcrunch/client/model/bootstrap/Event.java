package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Event(
    int id,
    String name,
    Instant deadlineTime,
    int averageEntryScore,
    boolean finished,
    boolean dataChecked,
    int highestScoringEntry,
    int deadlineTimeEpoch,
    int deadlineTimeGameOffset,
    int highestScore,
    boolean isPrevious,
    boolean isCurrent,
    boolean isNext,
    boolean cupLeaguesCreated,
    boolean h2HKoMatchesCreated,
    int rankedCount,
    List<ChipPlay> chipPlays,
    int mostSelected,
    int mostTransferredIn,
    int topElement,
    TopElementInfo topElementInfo,
    int transfersMade,
    int mostCaptained,
    int mostViceCaptained
) {

}
