package io.github.aj8gh.fplcrunch.client.model.entry.history;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EntryHistory(
    List<EntryHistoryEvent> current,
    List<Season> past,
    List<?> chips
) {

}
