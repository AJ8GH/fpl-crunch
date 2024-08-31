package io.github.aj8gh.fplcrunch.api;

import io.github.aj8gh.fplcrunch.client.FplClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public abstract class AbstractResource {

  @RestClient
  protected FplClient client;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  protected Response ok(Object object) {
    return Response.ok(object).build();
  }
}
