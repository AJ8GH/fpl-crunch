package io.github.aj8gh.fplcrunch.client.model.bootstrap;

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
    Integer squadMinPlay,
    Integer squadMaxPlay,
    Boolean uiShirtSpecific,
    List<Integer> subPositionsLocked,
    Integer elementCount
) {

}
