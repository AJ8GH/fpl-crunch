package io.github.aj8gh.fplcrunch.client.model.element;

import java.math.BigDecimal;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementHistoryPast(
    String seasonName,
    int elementCode,
    int startCost,
    int endCost,
    int totalPoints,
    int minutes,
    int goalsScored,
    int assists,
    int cleanSheets,
    int goalsConceded,
    int ownGoals,
    int penaltiesSaved,
    int penaltiesMissed,
    int yellowCards,
    int redCards,
    int saves,
    int bonus,
    int bps,
    BigDecimal influence,
    BigDecimal creativity,
    BigDecimal threat,
    BigDecimal ictIndex,
    int starts,
    BigDecimal expectedGoals,
    BigDecimal expectedAssists,
    BigDecimal expectedGoalInvolvements,
    BigDecimal expectedGoalsConceded
) {

}
