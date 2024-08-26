package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementType(
    int id,
    String pluralName,
    String pluralNameShort,
    String singularName,
    String singularNameShort,
    int squadSelect,
    int squadMinPlay,
    int squadMaxPlay,
    boolean uiShirtSpecific,
    List<Integer> subPositionsLocked,
    int elementCount
) {

}
