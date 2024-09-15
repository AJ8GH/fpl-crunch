package io.github.aj8gh.fplcrunch.api.model.response.bootstrap;

import java.time.ZoneId;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record GameSettings(
    Integer leagueJoinPrivateMax,
    Integer leagueJoinPublicMax,
    Integer leagueMaxSizePublicClassic,
    Integer leagueMaxSizePublicHeadToHead,
    Integer leagueMaxSizePrivateHeadToHead,
    Integer leagueMaxKoRoundsPrivateHeadToHead,
    String leaguePrefixPublic,
    Integer leaguePointsHeadToHeadWin,
    Integer leaguePointsHeadToHeadLose,
    Integer leaguePointsHeadToHeadDraw,
    Boolean leagueKoFirstInsteadOfRandom,
    Integer cupStartEventId,
    Integer cupStopEventId,
    String cupQualifyingMethod,
    String cupType,
    List<Integer> featuredEntries,
    List<Integer> percentileRanks,
    Integer squadSquadplay,
    Integer squadSquadsize,
    Integer squadTeamLimit,
    Integer squadTotalSpend,
    Integer uiCurrencyMultiplier,
    Boolean uiUseSpecialShirts,
    List<String> uiSpecialShirtExclusions,
    Integer statsFormDays,
    Boolean sysViceCaptainEnabled,
    Integer transfersCap,
    Integer transfersSellOnFee,
    Integer maxExtraFreeTransfers,
    List<String> leagueHeadToHeadTiebreakStats,
    ZoneId timezone
) {

}
