package io.github.aj8gh.fplcrunch.client.model.event;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record EventElement(
    Integer id,
    Stats stats,
    List<Explain> explain
) {

}
