package io.github.aj8gh.fplcrunch.client;

import static io.github.aj8gh.fplcrunch.client.ClientPath.API_BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BOOTSTRAP_STATIC;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ELEMENT_SUMMARY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY_HISTORY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY_PICKS;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY_TRANSFERS;
import static io.github.aj8gh.fplcrunch.client.ClientPath.EVENT_LIVE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.FIXTURES;
import static io.github.aj8gh.fplcrunch.client.ClientPath.LEAGUES_CLASSIC_STANDINGS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.client.model.response.bootstrap.Bootstrap;
import io.github.aj8gh.fplcrunch.client.model.response.element.ElementSummary;
import io.github.aj8gh.fplcrunch.client.model.response.entry.history.EntryHistory;
import io.github.aj8gh.fplcrunch.client.model.response.entry.pick.EntryPicks;
import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.Entry;
import io.github.aj8gh.fplcrunch.client.model.response.entry.transfer.EntryTransfer;
import io.github.aj8gh.fplcrunch.client.model.response.event.EventLive;
import io.github.aj8gh.fplcrunch.client.model.response.fixture.Fixture;
import io.github.aj8gh.fplcrunch.client.model.response.league.classic.ClassicLeagueStandings;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path(API_BASE)
@RegisterRestClient
public interface FplApiClient {

  @GET
  @Path(BOOTSTRAP_STATIC)
  @Consumes(APPLICATION_JSON)
  Bootstrap bootstrapStatic();

  @GET
  @Path(ELEMENT_SUMMARY)
  @Consumes(APPLICATION_JSON)
  ElementSummary elementSummary(int id);

  @GET
  @Path(ENTRY)
  @Consumes(APPLICATION_JSON)
  Entry entry(int id);

  @GET
  @Path(ENTRY_HISTORY)
  @Consumes(APPLICATION_JSON)
  EntryHistory entryHistory(int id);

  @GET
  @Path(ENTRY_PICKS)
  @Consumes(APPLICATION_JSON)
  EntryPicks entryPicks(int id, int gw);

  @GET
  @Path(ENTRY_TRANSFERS)
  @Consumes(APPLICATION_JSON)
  List<EntryTransfer> entryTransfers(int id);

  @GET
  @Path(EVENT_LIVE)
  @Consumes(APPLICATION_JSON)
  EventLive eventLive(int gw);

  @GET
  @Path(FIXTURES)
  @Consumes(APPLICATION_JSON)
  List<Fixture> fixtures();

  @GET
  @Path(LEAGUES_CLASSIC_STANDINGS)
  @Consumes(APPLICATION_JSON)
  ClassicLeagueStandings classicLeagueStandings(int id);
}
