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
    @JsonAlias("league_max_size_public_h2h") Integer leagueMaxSizePublicHeadToHead,
    @JsonAlias("league_max_size_private_h2h") Integer leagueMaxSizePrivateHeadToHead,
    @JsonAlias("league_max_ko_rounds_private_h2h") Integer leagueMaxKoRoundsPrivateHeadToHead,
    String leaguePrefixPublic,
    @JsonAlias("league_points_h2h_win") Integer leaguePointsHeadToHeadWin,
    @JsonAlias("league_points_h2h_lose") Integer leaguePointsHeadToHeadLose,
    @JsonAlias("league_points_h2h_draw") Integer leaguePointsHeadToHeadDraw,
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
    @JsonAlias("league_h2h_tiebreak_stats") List<String> leagueHeadToHeadTiebreakStats,
    ZoneId timezone
) {

}
