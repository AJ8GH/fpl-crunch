package io.github.aj8gh.fplcrunch.api.model.response.fixture;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FixtureStat(
    String identifier,
    @JsonAlias("a") List<FixtureStatDetail> away,
    @JsonAlias("h") List<FixtureStatDetail> home
) {

}
