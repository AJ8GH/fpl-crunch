package io.github.aj8gh.fplcrunch.api;

import io.github.aj8gh.fplcrunch.client.FplClient;
import io.github.aj8gh.fplcrunch.client.model.element.ElementSummary;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/element-summary/{id}")
public class ElementResource {

  @RestClient
  FplClient client;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ElementSummary elementSummary(int id) {
    return client.elementSummary(id);
  }
}
