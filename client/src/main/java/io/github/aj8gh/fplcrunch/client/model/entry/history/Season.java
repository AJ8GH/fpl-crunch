package io.github.aj8gh.fplcrunch.client.model.entry.history;

import lombok.Builder;

@Builder(toBuilder = true)
public record Season(
    String seasonName,
    Integer totalPoints,
    Integer rank
) {

}
