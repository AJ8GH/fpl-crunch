package io.github.aj8gh.fplcrunch.api.model.response.me;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FplPlayerResponse(
    Player player,
    List<?> watched
) {

}
