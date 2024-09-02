package io.github.aj8gh.fplcrunch.client.model.entry.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EntryHistory(
    List<EntryHistoryEvent> current,
    List<Season> past,
    @JsonIgnore List<?> chips
) {

}
