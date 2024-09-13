package io.github.aj8gh.fplcrunch.api.model.response.myteam;

import lombok.Builder;

@Builder(toBuilder = true)
public record TeamTransfers(
    Integer cost,
    String status,
    Integer limit,
    Integer made,
    Integer bank,
    Integer value
) {

}
