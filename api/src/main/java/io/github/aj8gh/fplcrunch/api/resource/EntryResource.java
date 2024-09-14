package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.Entry.BASE;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Entry.PICKS;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Entry.TRANSFERS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EntryMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(BASE)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class EntryResource extends AbstractResource {

  private final EntryMapper mapper;

  @GET
  public Response get(int id) {
    return ok(mapper.map(client.entry(id)));
  }

  @GET
  @Path(PICKS)
  public Response getPicks(int id, int gw) {
    return ok(mapper.map(client.entryPicks(id, gw)));
  }

  @GET
  @Path(TRANSFERS)
  public Response getTransfers(int id) {
    return ok(mapper.map(client.entryTransfers(id)));
  }
}
