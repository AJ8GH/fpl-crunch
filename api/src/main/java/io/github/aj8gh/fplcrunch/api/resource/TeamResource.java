package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.MY_TEAM;
import static io.github.aj8gh.fplcrunch.client.Cookies.PL_PROFILE;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.TeamMapper;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(MY_TEAM)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class TeamResource extends AbstractResource {

  private final TeamMapper mapper;

  @GET
  public Response me(@CookieParam(PL_PROFILE) String token, int id) {
    return ok(mapper.map(client.myTeam(token, id)));
  }
}
