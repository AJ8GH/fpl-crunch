package io.github.aj8gh.fplcrunch.api.model.response.element;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementHistory(
    Integer element,
    Integer fixture,
    Integer opponentTeam,
    Integer totalPoints,
    Boolean wasHome,
    Instant kickoffTime,
    Integer teamHomeScore,
    Integer teamAwayScore,
    Integer round,
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
    Integer value,
    Integer transfersBalance,
    Integer selected,
    Integer transfersIn,
    Integer transfersOut
) {

}
