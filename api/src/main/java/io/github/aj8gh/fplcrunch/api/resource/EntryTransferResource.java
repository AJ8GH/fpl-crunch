package io.github.aj8gh.fplcrunch.api.resource;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(ApiPath.ENTRY_TRANSFERS)
public class EntryTransferResource extends AbstractResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(int id) {
    return ok(client.entryTransfers(id));
  }
}
