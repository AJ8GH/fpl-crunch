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
import static io.github.aj8gh.fplcrunch.client.ClientPath.ME;
import static io.github.aj8gh.fplcrunch.client.Cookies.PL_PROFILE;
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
import io.github.aj8gh.fplcrunch.client.model.response.me.FplPlayer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path(API_BASE)
@RegisterRestClient
@Consumes(APPLICATION_JSON)
public interface FplApiClient {

  @GET
  @Path(BOOTSTRAP_STATIC)
  Bootstrap bootstrapStatic();

  @GET
  @Path(ELEMENT_SUMMARY)
  ElementSummary elementSummary(int id);

  @GET
  @Path(ENTRY)
  Entry entry(int id);

  @GET
  @Path(ENTRY_HISTORY)
  EntryHistory entryHistory(int id);

  @GET
  @Path(ENTRY_PICKS)
  EntryPicks entryPicks(int id, int gw);

  @GET
  @Path(ENTRY_TRANSFERS)
  List<EntryTransfer> entryTransfers(int id);

  @GET
  @Path(EVENT_LIVE)
  EventLive eventLive(int gw);

  @GET
  @Path(FIXTURES)
  List<Fixture> fixtures();

  @GET
  @Path(LEAGUES_CLASSIC_STANDINGS)
  ClassicLeagueStandings classicLeagueStandings(int id);

  @GET
  @Path(ME)
  FplPlayer me(@CookieParam(PL_PROFILE) String token);
}
