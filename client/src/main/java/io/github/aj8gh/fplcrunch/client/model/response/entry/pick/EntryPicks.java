package io.github.aj8gh.fplcrunch.client.model.response.entry.pick;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EntryPicks(
    String activeChip,
    List<?> automaticSubs,
    EntryPickHistory entryHistory,
    List<Pick> picks
) {

}
