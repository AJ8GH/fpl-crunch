package io.github.aj8gh.fplcrunch.client.model.league.classic;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Standings(
    Boolean hasNext,
    Integer page,
    List<Result> results
) {

}
