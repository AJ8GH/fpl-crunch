package io.github.aj8gh.fplcrunch.client.model.response.entry.transfer;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record EntryTransfer(
    Integer elementIn,
    Integer elementInCost,
    Integer elementOut,
    Integer elementOutCost,
    Integer entry,
    Integer event,
    Instant time
) {

}
