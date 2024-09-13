package io.github.aj8gh.fplcrunch.api.model.response.entry.history;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EntryHistoryResponse(
    List<EntryHistoryEvent> current,
    List<Season> past,
    List<?> chips
) {

}
