package io.github.aj8gh.fplcrunch.client.model.bootstrap;

import lombok.Builder;

@Builder(toBuilder = true)
public record TopElementInfo(
    int id,
    int points
) {

}
