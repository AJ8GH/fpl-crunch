package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.entry.pick.EntryPicksResponse;
import io.github.aj8gh.fplcrunch.api.model.response.entry.summary.EntryResponse;
import io.github.aj8gh.fplcrunch.api.model.response.entry.transfer.EntryTransferResponse;
import io.github.aj8gh.fplcrunch.client.model.response.entry.pick.EntryPicks;
import io.github.aj8gh.fplcrunch.client.model.response.entry.summary.Entry;
import io.github.aj8gh.fplcrunch.client.model.response.entry.transfer.EntryTransfer;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EntryMapper {

  EntryResponse map(Entry from);

  EntryPicksResponse map(EntryPicks from);

  List<EntryTransferResponse> map(List<EntryTransfer> from);
}
