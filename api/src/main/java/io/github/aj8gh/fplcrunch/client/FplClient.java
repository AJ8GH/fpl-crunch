package io.github.aj8gh.fplcrunch.client;

import static io.github.aj8gh.fplcrunch.client.Path.BOOTSTRAP_STATIC;
import static io.github.aj8gh.fplcrunch.client.Path.ELEMENT_SUMMARY;
import static io.github.aj8gh.fplcrunch.client.Path.FIXTURES;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import io.github.aj8gh.fplcrunch.client.model.element.ElementSummary;
import io.github.aj8gh.fplcrunch.client.model.fixture.Fixture;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface FplClient {

  @GET
  @Path(BOOTSTRAP_STATIC)
  @Consumes(APPLICATION_JSON)
  Bootstrap bootstrapStatic();

  @GET
  @Path(FIXTURES)
  @Consumes(APPLICATION_JSON)
  List<Fixture> fixtures();

  @GET
  @Path(ELEMENT_SUMMARY)
  @Consumes(APPLICATION_JSON)
  ElementSummary elementSummary(int id);
}
