package io.github.aj8gh.fplcrunch.client.model.response.entry.pick;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record EntryPicks(
    String activeChip,
    List<?> automaticSubs,
    EntryPickHistory entryHistory,
    List<Pick> picks
) {

}
