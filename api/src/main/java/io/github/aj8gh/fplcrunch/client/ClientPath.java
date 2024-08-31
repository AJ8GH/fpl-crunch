package io.github.aj8gh.fplcrunch.client;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientPath {

  public static final String BASE = "/api";
  public static final String BOOTSTRAP_STATIC = "/bootstrap-static/";
  public static final String FIXTURES = "/fixtures/";
  public static final String ELEMENT_SUMMARY = "/element-summary/{id}/";
  public static final String EVENT = "/event/{GW}/live/";
  public static final String ENTRY = "/entry/{team-id}/";
  public static final String ENTRY_PICKS = "/entry/{team-id}/event/{GW}/picks/";
  public static final String ENTRY_TRANSFERS = "/entry/{team-id}/transfers/";
  public static final String ENTRY_HISTORY = "/entry/{team-id}/history/";
  public static final String LEAGUES_CLASSIC = "/leagues-classic/{league-id}/standings/";
  public static final String LEAGUES_HEAD_TO_HEAD = "/leagues-h2h-matches/league/{league-ID}/";
}
