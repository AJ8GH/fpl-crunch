package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.Event.EVENTS;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Event.EVENT_LIVE;
import static io.github.aj8gh.fplcrunch.api.ApiPath.ROOT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.mapper.EventMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path(ROOT)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class EventResource extends AbstractResource {

  private final EventMapper mapper;

  @GET
  @Path(EVENT_LIVE)
  public Response getLive(int gw) {
    return ok(mapper.map(client.eventLive(gw)));
  }

  @GET
  @Path(EVENTS)
  public Response getAll() {
    return ok(mapper.map(client.events()));
  }
}
