package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.event.EventResponse;
import io.github.aj8gh.fplcrunch.api.model.response.event.live.EventLiveResponse;
import io.github.aj8gh.fplcrunch.client.model.response.event.Event;
import io.github.aj8gh.fplcrunch.client.model.response.event.live.EventLive;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {

  EventLiveResponse map(EventLive from);

  List<EventResponse> map(List<Event> from);
}
