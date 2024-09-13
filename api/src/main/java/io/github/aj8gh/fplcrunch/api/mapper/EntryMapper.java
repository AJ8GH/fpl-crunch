package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.entry.summary.EntryResponse;
import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.Entry;
import org.mapstruct.Mapper;

@Mapper
public interface EntryMapper {

  EntryResponse map(Entry from);
}
