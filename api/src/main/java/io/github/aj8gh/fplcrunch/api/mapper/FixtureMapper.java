package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.fixture.FixtureResponse;
import io.github.aj8gh.fplcrunch.client.model.response.fixture.Fixture;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface FixtureMapper {

  List<FixtureResponse> map(List<Fixture> from);
}
