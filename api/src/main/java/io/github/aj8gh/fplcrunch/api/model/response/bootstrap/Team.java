package io.github.aj8gh.fplcrunch.api.model.response.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record Team(
    Integer code,
    Integer draw,
    Integer form,
    Integer id,
    Integer loss,
    String name,
    Integer played,
    Integer points,
    Integer position,
    String shortName,
    Integer strength,
    String teamDivision,
    Boolean unavailable,
    Integer win,
    Integer strengthOverallHome,
    Integer strengthOverallAway,
    Integer strengthAttackHome,
    Integer strengthAttackAway,
    Integer strengthDefenceHome,
    Integer strengthDefenceAway,
    Integer pulseId
) {

}
