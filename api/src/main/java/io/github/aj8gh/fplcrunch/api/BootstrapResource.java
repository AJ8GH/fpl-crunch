package io.github.aj8gh.fplcrunch.api;

import io.github.aj8gh.fplcrunch.client.FplClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/bootstrap")
public class BootstrapResource {

  @RestClient
  FplClient client;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    return Response
        .ok(client.bootstrapStatic())
        .build();
  }
}
