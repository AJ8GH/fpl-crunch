package io.github.aj8gh.fplcrunch.api.model.response.entry.transfer;

import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
public record EntryTransferResponse(
    Integer elementIn,
    Integer elementInCost,
    Integer elementOut,
    Integer elementOutCost,
    Integer entry,
    Integer event,
    Instant time
) {

}
