package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.myteam.FplTeamResponse;
import io.github.aj8gh.fplcrunch.client.model.response.myteam.FplTeam;
import org.mapstruct.Mapper;

@Mapper
public interface TeamMapper {

  FplTeamResponse map(FplTeam from);
}
