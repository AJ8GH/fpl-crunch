package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.element.ElementSummaryResponse;
import io.github.aj8gh.fplcrunch.client.model.response.element.ElementSummary;
import org.mapstruct.Mapper;

@Mapper
public interface ElementMapper {

  ElementSummaryResponse map(ElementSummary from);
}
