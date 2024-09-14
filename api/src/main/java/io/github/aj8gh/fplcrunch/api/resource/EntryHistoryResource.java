package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.ENTRY_HISTORY;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EntryHistoryMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(ENTRY_HISTORY)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class EntryHistoryResource extends AbstractResource {

  private final EntryHistoryMapper mapper;

  @GET
  public Response get(int id) {
    return ok(mapper.map(client.entryHistory(id)));
  }
}
