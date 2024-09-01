package io.github.aj8gh.fplcrunch.client;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientPath {

  public static final String BASE = "/api";
  public static final String BOOTSTRAP_STATIC = "/bootstrap-static/";
  public static final String FIXTURES = "/fixtures/";
  public static final String ELEMENT_SUMMARY = "/element-summary/{id}/";
  public static final String EVENT = "/event/{gw}/live/";
  public static final String MY_TEAM = "/my-team/{id}/";
  public static final String ME = "/me/";
  public static final String ENTRY = "/entry/{id}/";
  public static final String ENTRY_CUP = "/entry/{id}/cup/";
  public static final String ENTRY_PICKS = "/entry/{id}/event/{gw}/picks/";
  public static final String ENTRY_TRANSFERS = "/entry/{id}/transfers/";
  public static final String ENTRY_TRANSFERS_LATEST = "/entry/{id}/transfers-latest /";
  public static final String ENTRY_HISTORY = "/entry/{id}/history/";
  public static final String LEAGUES_CLASSIC = "/leagues-classic/{id}/standings/";
  public static final String LEAGUES_HEAD_TO_HEAD = "/leagues-h2h-matches/league/{id}/";
}
