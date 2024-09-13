package io.github.aj8gh.fplcrunch.client.model.response.me;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDate;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(SnakeCaseStrategy.class)
public record Player(
    LocalDate dateOfBirth,
    Integer defaultEvent,
    Boolean dirty,
    String firstName,
    String gender,
    Integer id,
    String lastName,
    Integer region,
    String email,
    Integer entry,
    Boolean entryEmail,
    String entryLanguage
) {

}
