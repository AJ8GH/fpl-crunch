package io.github.aj8gh.fplcrunch.client.model.response.myteam;

import lombok.Builder;

@Builder(toBuilder = true)
public record TeamPick(
    Integer element,
    Integer position,
    Integer sellingPrice,
    Integer multiplier,
    Integer purchasePrice,
    Boolean isCaptain,
    Boolean isViceCaptain
) {

}
