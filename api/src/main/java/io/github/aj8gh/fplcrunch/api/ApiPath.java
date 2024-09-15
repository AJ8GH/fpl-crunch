package io.github.aj8gh.fplcrunch.api;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiPath {

  public static final String API = "/api";
  public static final String ROOT = "/";
  public static final String BOOTSTRAP = "/bootstrap";
  public static final String ELEMENT_SUMMARY = "/element-summary/{id}";
  public static final String FIXTURES = "/fixtures";
  public static final String ME = "/me";
  public static final String MY_TEAM = "/my-team/{id}";

  @UtilityClass
  public static class Event {

    public static final String EVENTS = "/events";
    public static final String EVENT_LIVE = "/event/{gw}/live";
  }

  @UtilityClass
  public static class Login {

    public static final String BASE = "/accounts/login";
    public static final String DEFAULT = "/default";
  }

  @UtilityClass
  public static class Entry {

    public static final String BASE = "/entry/{id}";
    public static final String CUP = "/cup";
    public static final String HISTORY = "/history";
    public static final String PICKS = "/event/{gw}/picks";
    public static final String TRANSFERS = "/transfers";
    public static final String TRANSFERS_LATEST = "/transfers-latest";
  }

  @UtilityClass
  public static class Leagues {

    public static final String LEAGUES_CLASSIC = "/leagues-classic/{id}";
    public static final String STANDINGS = "/standings";
    public static final String LEAGUES_HEAD_TO_HEAD = "/leagues-h2h-matches/league/{id}";
  }
}
