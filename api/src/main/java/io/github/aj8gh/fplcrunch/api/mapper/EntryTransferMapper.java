package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.entry.transfer.EntryTransferResponse;
import io.github.aj8gh.fplcrunch.client.model.response.entry.transfer.EntryTransfer;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EntryTransferMapper {

  List<EntryTransferResponse> map(List<EntryTransfer> from);
}
