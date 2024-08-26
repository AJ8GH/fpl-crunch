package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record Team(
    int code,
    int draw,
    Integer form,
    int id,
    int loss,
    String name,
    int played,
    int points,
    int position,
    String shortName,
    int strength,
    Boolean unavailable,
    int win,
    int strengthOverallHome,
    int strengthOverallAway,
    int strengthAttackHome,
    int strengthAttackAway,
    int strengthDefenceHome,
    int strengthDefenceAway,
    int pulseId
) {

}
