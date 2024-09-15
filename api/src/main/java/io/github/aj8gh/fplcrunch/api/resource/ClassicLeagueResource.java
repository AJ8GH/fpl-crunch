package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.Leagues.LEAGUES_CLASSIC;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Leagues.STANDINGS;
import static io.github.aj8gh.fplcrunch.client.QueryParams.PAGE_STANDINGS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.ClassicLeagueMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(LEAGUES_CLASSIC)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class ClassicLeagueResource extends AbstractResource {

  private final ClassicLeagueMapper mapper;

  @GET
  @Path(STANDINGS)
  public Response standings(@QueryParam(PAGE_STANDINGS) Integer page, int id) {
    var response = client.classicLeagueStandings(query(PAGE_STANDINGS, page), id);
    return ok(mapper.map(response));
  }
}
