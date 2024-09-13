package io.github.aj8gh.fplcrunch.api.model.response.fixture;

import lombok.Builder;

@Builder(toBuilder = true)
public record FixtureStatDetail(
    Integer value,
    Integer element
) {

}
