package io.github.aj8gh.fplcrunch.client.model.fixture;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FixtureStat(
   String identifier,
   List<FixtureStatDetail> a,
   List<FixtureStatDetail> h
) {

}
