package io.github.aj8gh.fplcrunch.client.model.response.me;

import java.time.LocalDate;
import lombok.Builder;

@Builder(toBuilder = true)
public record Player(
    LocalDate dateOfBirth,
    Integer defaultEvent,
    Boolean dirty,
    Boolean firstName,
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
