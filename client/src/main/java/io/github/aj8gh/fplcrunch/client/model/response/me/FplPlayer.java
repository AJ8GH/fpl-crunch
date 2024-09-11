package io.github.aj8gh.fplcrunch.client.model.response.me;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record FplPlayer(
    Player player,
    List<?> watched
) {

}
