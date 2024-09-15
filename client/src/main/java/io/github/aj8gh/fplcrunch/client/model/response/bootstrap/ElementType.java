package io.github.aj8gh.fplcrunch.client.model.response.bootstrap;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ElementType(
    Integer id,
    String pluralName,
    String pluralNameShort,
    String singularName,
    String singularNameShort,
    Integer squadSelect,
    Integer squadMinSelect,
    Integer squadMaxSelect,
    Integer squadMinPlay,
    Integer squadMaxPlay,
    Boolean uiShirtSpecific,
    List<Integer> subPositionsLocked,
    Integer elementCount
) {

}
