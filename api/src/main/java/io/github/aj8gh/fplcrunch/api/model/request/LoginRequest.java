package io.github.aj8gh.fplcrunch.api.model.request;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record LoginRequest(
    @NonNull String login,
    @NonNull String password
) {

}
