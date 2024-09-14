package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.Leagues.LEAGUES_CLASSIC;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Leagues.STANDINGS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.ClassicLeagueStandingsMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(LEAGUES_CLASSIC)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class ClassicLeagueResource extends AbstractResource {

  private final ClassicLeagueStandingsMapper mapper;

  @GET
  @Path(STANDINGS)
  public Response standings(int id) {
    return ok(mapper.map(client.classicLeagueStandings(id)));
  }
}
