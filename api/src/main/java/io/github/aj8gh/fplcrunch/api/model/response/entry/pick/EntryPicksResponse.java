package io.github.aj8gh.fplcrunch.api.model.response.entry.pick;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EntryPicksResponse(
    String activeChip,
    List<?> automaticSubs,
    EntryPickHistory entryHistory,
    List<Pick> picks
) {

}
