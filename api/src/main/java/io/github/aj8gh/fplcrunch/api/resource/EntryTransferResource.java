package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.ENTRY_TRANSFERS;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EntryTransferMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(ENTRY_TRANSFERS)
@RequiredArgsConstructor
public class EntryTransferResource extends AbstractResource {

  private final EntryTransferMapper mapper;

  @GET
  @Produces(APPLICATION_JSON)
  public Response get(int id) {
    return ok(mapper.map(client.entryTransfers(id)));
  }
}
