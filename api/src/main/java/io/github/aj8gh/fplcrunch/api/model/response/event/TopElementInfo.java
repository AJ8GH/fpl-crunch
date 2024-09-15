package io.github.aj8gh.fplcrunch.api.model.response.event;

import lombok.Builder;

@Builder(toBuilder = true)
public record TopElementInfo(
    Integer id,
    Integer points
) {

}
