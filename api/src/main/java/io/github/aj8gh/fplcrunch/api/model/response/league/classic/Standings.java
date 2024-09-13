package io.github.aj8gh.fplcrunch.api.model.response.league.classic;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Standings(
    Boolean hasNext,
    Integer page,
    List<Result> results
) {

}
