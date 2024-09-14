package io.github.aj8gh.fplcrunch.api.ext;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.status;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.github.aj8gh.fplcrunch.api.util.Loader.BOOTSTRAP_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.ELEMENT_SUMMARY_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.ENTRY_HISTORY_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.ENTRY_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.ENTRY_PICKS_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.ENTRY_TRANSFERS_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.EVENT_LIVE_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.FIXTURES_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.LEAGUES_CLASSIC_STANDINGS_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.ME_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.MY_TEAM_JSON;
import static io.github.aj8gh.fplcrunch.api.util.Loader.RESPONSES;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ACCOUNTS_BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.API_BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BOOTSTRAP_STATIC;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ELEMENT_SUMMARY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY_HISTORY;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY_PICKS;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ENTRY_TRANSFERS;
import static io.github.aj8gh.fplcrunch.client.ClientPath.EVENT_LIVE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.FIXTURES;
import static io.github.aj8gh.fplcrunch.client.ClientPath.LEAGUES_CLASSIC_STANDINGS;
import static io.github.aj8gh.fplcrunch.client.ClientPath.LOGIN;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ME;
import static io.github.aj8gh.fplcrunch.client.ClientPath.MY_TEAM;
import static io.github.aj8gh.fplcrunch.client.Cookies.PL_PROFILE;
import static io.github.aj8gh.fplcrunch.client.Cookies.SESSION_ID;
import static io.github.aj8gh.fplcrunch.client.FormParams.APP_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.APP_VALUE;
import static io.github.aj8gh.fplcrunch.client.FormParams.LOGIN_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.PASSWORD_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.REDIRECT_URI_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.REDIRECT_URI_VALUE;
import static io.github.aj8gh.fplcrunch.client.Headers.ACCEPT_LANGUAGE_VALUE;
import static io.github.aj8gh.fplcrunch.client.Headers.LOGIN_STATUS;
import static io.github.aj8gh.fplcrunch.client.Headers.USER_AGENT_VALUE;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT_LANGUAGE;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static jakarta.ws.rs.core.HttpHeaders.LOCATION;
import static jakarta.ws.rs.core.HttpHeaders.SET_COOKIE;
import static jakarta.ws.rs.core.HttpHeaders.USER_AGENT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.lang.String.valueOf;
import static java.util.Collections.emptyMap;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.FOUND;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.github.aj8gh.fplcrunch.api.model.request.LoginRequest;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@ApplicationScoped
public class WireMockExtensions implements QuarkusTestResourceLifecycleManager {

  public static final int ID = 99;
  public static final int GW = 3;
  public static final String SUCCESS = "success";
  public static final String LOCATION_VALUE = "https://fantasy.premierleague.com/?state=success";
  public static final String PL_PROFILE_VALUE = "eyWwKkaCdD9m0Pasc=";
  public static final String SESSION_ID_VALUE = "jkashduwn98kjahsd7sdf";
  public static final String PL_PROFILE_FULL_VALUE = STR."""
  \{PL_PROFILE_VALUE}; Domain=premierleague.com; expires=Thu, 19 Sep 2024 20:24:56 GMT; Max-Age=1209600; Path=/; Secure""";
  public static final String SESSION_ID_FULL_VALUE = STR."""
  \{SESSION_ID_VALUE}; expires=Thu, 19 Sep 2024 20:24:56 GMT; HttpOnly; Max-Age=1209600; Path=/; SameSite=Lax""";

  private static final String ID_PLACEHOLDER = "{id}";
  private static final String GW_PLACEHOLDER = "{gw}";
  private static final int WIREMOCK_PORT = 8888;
  private static final WireMockServer WIRE_MOCK = new WireMockServer(WIREMOCK_PORT);

  @Override
  public Map<String, String> start() {
    WIRE_MOCK.start();
    return emptyMap();
  }

  @Override
  public void stop() {
    WIRE_MOCK.stop();
  }

  @SneakyThrows
  public static void stubHappyPath(String path) {
    WIRE_MOCK.stubFor(get(urlEqualTo(API_BASE + path
        .replace(ID_PLACEHOLDER, valueOf(ID))
        .replace(GW_PLACEHOLDER, valueOf(GW))))
        .willReturn(ok()
            .withBodyFile(RESPONSES + pathToJson(path))
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)));
  }

  @SneakyThrows
  public static void stubAuthenticatedHappyPath(String path) {
    WIRE_MOCK.stubFor(get(urlEqualTo(API_BASE + path
        .replace(ID_PLACEHOLDER, valueOf(ID))
        .replace(GW_PLACEHOLDER, valueOf(GW))))
        .withCookie(PL_PROFILE, equalTo(PL_PROFILE_VALUE))
        .willReturn(ok()
            .withBodyFile(RESPONSES + pathToJson(path))
            .withHeader(CONTENT_TYPE, APPLICATION_JSON)));
  }

  public static void stubLoginPath(LoginRequest request) {
    WIRE_MOCK.stubFor(post(urlEqualTo(ACCOUNTS_BASE + LOGIN))
        .withFormParam(LOGIN_NAME, equalTo(request.login()))
        .withFormParam(PASSWORD_NAME, equalTo(request.password()))
        .withFormParam(APP_NAME, equalTo(APP_VALUE))
        .withFormParam(REDIRECT_URI_NAME, equalTo(REDIRECT_URI_VALUE))
        .withHeader(ACCEPT_LANGUAGE, equalTo(ACCEPT_LANGUAGE_VALUE))
        .withHeader(USER_AGENT, equalTo(USER_AGENT_VALUE))
        .willReturn(status(FOUND)
            .withHeader(LOGIN_STATUS, SUCCESS)
            .withHeader(LOCATION, LOCATION_VALUE)
            .withHeader(SET_COOKIE, STR."\{PL_PROFILE}=\{PL_PROFILE_FULL_VALUE}")
            .withHeader(SET_COOKIE, STR."\{SESSION_ID}=\{SESSION_ID_FULL_VALUE}")));
  }

  private static String pathToJson(String path) {
    return switch (path) {
      case BOOTSTRAP_STATIC -> BOOTSTRAP_JSON;
      case ELEMENT_SUMMARY -> ELEMENT_SUMMARY_JSON;
      case ENTRY -> ENTRY_JSON;
      case ENTRY_HISTORY -> ENTRY_HISTORY_JSON;
      case ENTRY_PICKS -> ENTRY_PICKS_JSON;
      case ENTRY_TRANSFERS -> ENTRY_TRANSFERS_JSON;
      case EVENT_LIVE -> EVENT_LIVE_JSON;
      case FIXTURES -> FIXTURES_JSON;
      case LEAGUES_CLASSIC_STANDINGS -> LEAGUES_CLASSIC_STANDINGS_JSON;
      case ME -> ME_JSON;
      case MY_TEAM -> MY_TEAM_JSON;
      default -> null;
    };
  }
}
