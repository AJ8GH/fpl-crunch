package io.github.aj8gh.fplcrunch.client.model.response.fixture;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record FixtureStat(
    String identifier,
    @JsonAlias("a") List<FixtureStatDetail> away,
    @JsonAlias("h") List<FixtureStatDetail> home
) {

}
