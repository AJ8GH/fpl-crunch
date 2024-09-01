package io.github.aj8gh.fplcrunch.client.model.element;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ElementSummary(
    List<ElementFixture> fixtures,
    List<ElementHistory> history,
    List<ElementHistoryPast> historyPast
) {

}
