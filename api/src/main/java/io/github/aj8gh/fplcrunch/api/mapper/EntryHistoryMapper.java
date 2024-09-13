package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.entry.history.EntryHistoryResponse;
import io.github.aj8gh.fplcrunch.client.model.response.entry.history.EntryHistory;
import org.mapstruct.Mapper;

@Mapper
public interface EntryHistoryMapper {

  EntryHistoryResponse map(EntryHistory from);
}
