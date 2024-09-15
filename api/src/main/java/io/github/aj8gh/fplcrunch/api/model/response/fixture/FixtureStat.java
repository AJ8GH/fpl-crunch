package io.github.aj8gh.fplcrunch.api.model.response.fixture;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FixtureStat(
    String identifier,
    List<FixtureStatDetail> away,
    List<FixtureStatDetail> home
) {

}
