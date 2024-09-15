package io.github.aj8gh.fplcrunch.api.model.response.bootstrap;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
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
