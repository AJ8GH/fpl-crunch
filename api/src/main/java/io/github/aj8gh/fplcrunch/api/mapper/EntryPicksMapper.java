package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.entry.pick.EntryPicksResponse;
import io.github.aj8gh.fplcrunch.client.model.response.entry.pick.EntryPicks;
import org.mapstruct.Mapper;

@Mapper
public interface EntryPicksMapper {

  EntryPicksResponse map(EntryPicks from);
}
