package io.github.aj8gh.fplcrunch.api;

import io.github.aj8gh.fplcrunch.client.FplClient;
import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/bootstrap")
public class BootstrapResource {

  @RestClient
  FplClient client;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Bootstrap bootstrap() {
    return client.bootstrapStatic();
  }
}
