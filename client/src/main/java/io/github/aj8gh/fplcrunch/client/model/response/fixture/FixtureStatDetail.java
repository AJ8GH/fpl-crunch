package io.github.aj8gh.fplcrunch.client.model.response.fixture;

import lombok.Builder;

@Builder(toBuilder = true)
public record FixtureStatDetail(
    Integer value,
    Integer element
) {

}
