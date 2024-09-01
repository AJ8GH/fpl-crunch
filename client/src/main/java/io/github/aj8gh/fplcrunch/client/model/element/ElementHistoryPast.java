package io.github.aj8gh.fplcrunch.client.model.element;

import java.math.BigDecimal;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementHistoryPast(
    String seasonName,
    Integer elementCode,
    Integer startCost,
    Integer endCost,
    Integer totalPoints,
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
    BigDecimal expectedGoalsConceded
) {

}
