package io.github.aj8gh.fplcrunch.client.model.response.bootstrap;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Event(
    Integer id,
    String name,
    Instant deadlineTime,
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
    @JsonAlias("h2HKoMatchesCreated") Boolean headToHeadKoMatchesCreated,
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
