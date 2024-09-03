package io.github.aj8gh.fplcrunch.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(ApiPath.LEAGUES_CLASSIC_STANDINGS)
public class ClassicLeagueStandingsResource extends AbstractResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(int id) {
    return ok(client.classicLeagueStandings(id));
  }
}
