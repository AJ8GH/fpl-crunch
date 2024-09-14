package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.BOOTSTRAP;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.BootstrapMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(BOOTSTRAP)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class BootstrapResource extends AbstractResource {

  private final BootstrapMapper mapper;

  @GET
  public Response get() {
    return ok(mapper.map(client.bootstrapStatic()));
  }
}
