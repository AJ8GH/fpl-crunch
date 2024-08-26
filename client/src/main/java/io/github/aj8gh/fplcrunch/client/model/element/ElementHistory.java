package io.github.aj8gh.fplcrunch.client.model.element;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementHistory(
    int element,
    int fixture,
    int opponentTeam,
    int totalPoints,
    boolean wasHome,
    Instant kickoffTime,
    int teamHScore,
    int teamAScore,
    int round,
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
    BigDecimal expectedGoalsConceded,
    int value,
    int transfersBalance,
    int selected,
    int transfersIn,
    int transfersOut
) {

}
