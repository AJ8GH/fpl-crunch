package io.github.aj8gh.fplcrunch.client.model.response.element;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record ElementSummary(
    List<ElementFixture> fixtures,
    List<ElementHistory> history,
    List<ElementHistoryPast> historyPast
) {

}
