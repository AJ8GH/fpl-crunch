package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.EVENT_LIVE;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EventLiveMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(EVENT_LIVE)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class EventResource extends AbstractResource {

  private final EventLiveMapper mapper;

  @GET
  public Response get(int gw) {
    return ok(mapper.map(client.eventLive(gw)));
  }
}
