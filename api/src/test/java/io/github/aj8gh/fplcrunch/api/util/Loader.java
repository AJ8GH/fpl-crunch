package io.github.aj8gh.fplcrunch.api.util;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aj8gh.fplcrunch.client.model.response.bootstrap.Bootstrap;
import io.github.aj8gh.fplcrunch.client.model.response.element.ElementSummary;
import io.github.aj8gh.fplcrunch.client.model.response.entry.history.EntryHistory;
import io.github.aj8gh.fplcrunch.client.model.response.entry.pick.EntryPicks;
import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.Entry;
import io.github.aj8gh.fplcrunch.client.model.response.entry.transfer.EntryTransfer;
import io.github.aj8gh.fplcrunch.client.model.response.event.EventLive;
import io.github.aj8gh.fplcrunch.client.model.response.fixture.Fixture;
import io.github.aj8gh.fplcrunch.client.model.response.league.classic.ClassicLeagueStandings;
import io.github.aj8gh.fplcrunch.client.model.response.me.FplPlayer;
import java.util.List;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Loader {

  public static final ObjectMapper MAPPER = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(WRITE_DATES_AS_TIMESTAMPS, false)
      .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

  public static final String FILES = "__files/";
  public static final String RESPONSES = "responses/";
  public static final String BOOTSTRAP_JSON = "bootstrap-static.json";
  public static final String ELEMENT_SUMMARY_JSON = "element-summary.json";
  public static final String ENTRY_JSON = "entry.json";
  public static final String ENTRY_HISTORY_JSON = "entry-history.json";
  public static final String ENTRY_PICKS_JSON = "entry-picks.json";
  public static final String ENTRY_TRANSFERS_JSON = "entry-transfers.json";
  public static final String EVENT_LIVE_JSON = "event-live.json";
  public static final String FIXTURES_JSON = "fixtures.json";
  public static final String LEAGUES_CLASSIC_STANDINGS_JSON = "leagues-classic-standings.json";
  public static final String ME_JSON = "authenticated/me.json";
  public static final String MY_TEAM_JSON = "authenticated/my-team.json";

  public static Bootstrap bootstrapStatic() {
    return load(BOOTSTRAP_JSON, Bootstrap.class);
  }

  public ElementSummary elementSummary() {
    return load(ELEMENT_SUMMARY_JSON, ElementSummary.class);
  }

  public static Entry entry() {
    return load(ENTRY_JSON, Entry.class);
  }

  public static EntryHistory entryHistory() {
    return load(ENTRY_HISTORY_JSON, EntryHistory.class);
  }

  public static EntryPicks entryPicks() {
    return load(ENTRY_PICKS_JSON, EntryPicks.class);
  }

  public static List<EntryTransfer> entryTransfers() {
    return load(ENTRY_TRANSFERS_JSON, new TypeReference<>() {
    });
  }

  public static EventLive eventLive() {
    return load(EVENT_LIVE_JSON, EventLive.class);
  }

  public List<Fixture> fixtures() {
    return load(FIXTURES_JSON, new TypeReference<>() {
    });
  }

  public static ClassicLeagueStandings classicLeagueStandings() {
    return load(LEAGUES_CLASSIC_STANDINGS_JSON, ClassicLeagueStandings.class);
  }

  public static FplPlayer fplPlayer() {
    return load(ME_JSON, FplPlayer.class);
  }

  @SneakyThrows
  private static <T> T load(String file, Class<T> type) {
    return MAPPER.readValue(
        Loader.class.getClassLoader().getResourceAsStream(FILES + RESPONSES + file),
        type);
  }

  @SneakyThrows
  private static <T> T load(String file, TypeReference<T> type) {
    return MAPPER.readValue(
        Loader.class.getClassLoader().getResourceAsStream(FILES + RESPONSES + file),
        type);
  }
}
