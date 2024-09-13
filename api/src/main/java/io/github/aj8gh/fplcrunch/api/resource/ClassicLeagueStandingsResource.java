package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.LEAGUES_CLASSIC_STANDINGS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.ClassicLeagueStandingsMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(LEAGUES_CLASSIC_STANDINGS)
@RequiredArgsConstructor
public class ClassicLeagueStandingsResource extends AbstractResource {

  private final ClassicLeagueStandingsMapper mapper;

  @GET
  @Produces(APPLICATION_JSON)
  public Response get(int id) {
    return ok(mapper.map(client.classicLeagueStandings(id)));
  }
}
