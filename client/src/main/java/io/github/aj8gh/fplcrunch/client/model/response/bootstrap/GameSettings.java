package io.github.aj8gh.fplcrunch.client.model.response.bootstrap;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.ZoneId;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record GameSettings(
    Integer leagueJoinPrivateMax,
    Integer leagueJoinPublicMax,
    Integer leagueMaxSizePublicClassic,
    @JsonAlias("leagueMaxSizePublicH2H") Integer leagueMaxSizePublicHeadToHead,
    @JsonAlias("leagueMaxSizePrivateH2H") Integer leagueMaxSizePrivateHeadToHead,
    @JsonAlias("leagueMaxKoRoundsPrivateH2H") Integer leagueMaxKoRoundsPrivateHeadToHead,
    String leaguePrefixPublic,
    @JsonAlias("leaguePointsH2HWin") Integer leaguePointsHeadToHeadWin,
    @JsonAlias("leaguePointsH2HLose") Integer leaguePointsHeadToHeadLose,
    @JsonAlias("leaguePointsH2HDraw") Integer leaguePointsHeadToHeadDraw,
    Boolean leagueKoFirstInsteadOfRandom,
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
    @JsonAlias("leagueH2HTiebreakStats") List<String> leagueHeadToHeadTiebreakStats,
    ZoneId timezone
) {

}
