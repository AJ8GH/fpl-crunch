package io.github.aj8gh.fplcrunch.client.model.response.myteam;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
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
