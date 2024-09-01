package io.github.aj8gh.fplcrunch.client;

import static io.github.aj8gh.fplcrunch.client.ClientPath.BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BOOTSTRAP_STATIC;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ELEMENT_SUMMARY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.FIXTURES;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import io.github.aj8gh.fplcrunch.client.model.element.ElementSummary;
import io.github.aj8gh.fplcrunch.client.model.entry.Entry;
import io.github.aj8gh.fplcrunch.client.model.fixture.Fixture;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path(BASE)
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

  @GET
  @Path(ENTRY)
  @Consumes(APPLICATION_JSON)
  Entry entry(int id);
}
