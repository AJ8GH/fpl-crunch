package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.FIXTURES;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.FixtureMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(FIXTURES)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class FixtureResource extends AbstractResource {

  private final FixtureMapper mapper;

  @GET
  public Response get() {
    return ok(mapper.map(client.fixtures()));
  }
}
