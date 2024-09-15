package io.github.aj8gh.fplcrunch.api.mapper;

import io.github.aj8gh.fplcrunch.api.model.response.league.classic.ClassicLeagueStandingsResponse;
import io.github.aj8gh.fplcrunch.client.model.response.league.classic.ClassicLeagueStandings;
import org.mapstruct.Mapper;

@Mapper
public interface ClassicLeagueMapper {

  ClassicLeagueStandingsResponse map(ClassicLeagueStandings from);
}
