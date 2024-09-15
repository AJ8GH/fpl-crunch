package io.github.aj8gh.fplcrunch.client.model.response.event.live;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record EventElement(
    Integer id,
    Stats stats,
    List<Explain> explain
) {

}
