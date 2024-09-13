package io.github.aj8gh.fplcrunch.api.model.response.element;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementSummaryResponse(
    List<ElementFixture> fixtures,
    List<ElementHistory> history,
    List<ElementHistoryPast> historyPast
) {

}
