package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.ENTRY;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EntryMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(ENTRY)
@RequiredArgsConstructor
public class EntryResource extends AbstractResource {

  private final EntryMapper mapper;

  @GET
  @Produces(APPLICATION_JSON)
  public Response get(int id) {
    return ok(mapper.map(client.entry(id)));
  }
}
