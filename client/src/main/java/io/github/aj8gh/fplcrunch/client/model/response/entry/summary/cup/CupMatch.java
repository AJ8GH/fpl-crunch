package io.github.aj8gh.fplcrunch.client.model.response.entry.summary.cup;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record CupMatch(
    Integer id,
    Integer entry1Entry,
    String entry1Name,
    String entry1PlayerName,
    Integer entry1Points,
    Integer entry1Win,
    Integer entry1Draw,
    Integer entry1Loss,
    Integer entry1Total,
    Integer entry2Entry,
    String entry2Name,
    String entry2PlayerName,
    Integer entry2Points,
    Integer entry2Win,
    Integer entry2Draw,
    Integer entry2Loss,
    Integer entry2Total,
    Boolean isKnockout,
    Integer league,
    Integer winner,
    Integer seedValue,
    Integer event,
    Boolean tiebreak,
    Boolean isBye,
    String knockoutName
) {

}
