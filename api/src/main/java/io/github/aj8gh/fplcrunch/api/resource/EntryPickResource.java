package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.ENTRY_PICKS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EntryPicksMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(ENTRY_PICKS)
@RequiredArgsConstructor
public class EntryPickResource extends AbstractResource {

  private final EntryPicksMapper mapper;

  @GET
  @Produces(APPLICATION_JSON)
  public Response get(int id, int gw) {
    return ok(mapper.map(client.entryPicks(id, gw)));
  }
}
