package io.github.aj8gh.fplcrunch.client.model.response.event;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Stats(
    Integer minutes,
    Integer goalsScored,
    Integer assists,
    Integer cleanSheets,
    Integer goalsConceded,
    Integer ownGoals,
    Integer penaltiesSaved,
    Integer penaltiesMissed,
    Integer yellowCards,
    Integer redCards,
    Integer saves,
    Integer bonus,
    Integer bps,
    BigDecimal influence,
    BigDecimal creativity,
    BigDecimal threat,
    BigDecimal ictIndex,
    Integer starts,
    BigDecimal expectedGoals,
    BigDecimal expectedAssists,
    BigDecimal expectedGoalInvolvements,
    BigDecimal expectedGoalsConceded,
    Integer totalPoints,
    Boolean inDreamteam
) {

}
