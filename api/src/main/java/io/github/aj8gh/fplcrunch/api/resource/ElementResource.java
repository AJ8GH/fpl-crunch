package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.ELEMENT_SUMMARY;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.ElementSummaryMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(ELEMENT_SUMMARY)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class ElementResource extends AbstractResource {

  private final ElementSummaryMapper mapper;

  @GET
  public Response get(int id) {
    return ok(mapper.map(client.elementSummary(id)));
  }
}
