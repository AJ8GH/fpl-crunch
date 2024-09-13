package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.bootstrap.BootstrapResponse;
import io.github.aj8gh.fplcrunch.client.model.response.bootstrap.Bootstrap;
import org.mapstruct.Mapper;

@Mapper
public interface BootstrapMapper {

  BootstrapResponse map(Bootstrap from);
}
