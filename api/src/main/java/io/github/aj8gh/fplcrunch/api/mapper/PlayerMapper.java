package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.me.FplPlayerResponse;
import io.github.aj8gh.fplcrunch.client.model.response.me.FplPlayer;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {

  FplPlayerResponse map(FplPlayer from);
}
