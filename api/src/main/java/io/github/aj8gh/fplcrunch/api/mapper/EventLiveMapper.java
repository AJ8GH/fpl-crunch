package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.event.EventLiveResponse;
import io.github.aj8gh.fplcrunch.client.model.response.event.EventLive;
import org.mapstruct.Mapper;

@Mapper
public interface EventLiveMapper {

  EventLiveResponse map(EventLive from);
}
