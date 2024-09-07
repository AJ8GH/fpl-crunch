package io.github.aj8gh.fplcrunch.api.ext;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.status;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.github.aj8gh.fplcrunch.api.util.Loader.MAPPER;
import static io.github.aj8gh.fplcrunch.client.ClientPath.ACCOUNTS_BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.API_BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.LOGIN;
import static io.github.aj8gh.fplcrunch.client.Cookies.SESSION_ID;
import static io.github.aj8gh.fplcrunch.client.Cookies.SESSION_TOKEN;
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
import static jakarta.ws.rs.core.HttpHeaders.LOCATION;
import static jakarta.ws.rs.core.HttpHeaders.SET_COOKIE;
import static jakarta.ws.rs.core.HttpHeaders.USER_AGENT;
import static java.lang.String.valueOf;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.FOUND;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;
import lombok.SneakyThrows;

public class WireMockExtensions implements QuarkusTestResourceLifecycleManager {

  public static final int ID = 99;
  public static final int GW = 3;
  public static final String LOGIN_VALUE = "abc@testing.com";
  public static final String PASSWORD_VALUE = "password";
  public static final String LOCATION_VALUE = "https://fantasy.premierleague.com/?state=success";
  public static final String SESSION_TOKEN_VALUE = "\"eyWwKkaCdD9m0Pasc=\"";
  public static final String SESSION_TOKEN_FULL_VALUE = STR."""
  \{SESSION_TOKEN_VALUE}; \
  Domain=premierleague.com; \
  expires=Thu, 19 Sep 2024 20:24:56 GMT; \
  Max-Age=1209600; \
  Path=/; \
  Secure""";

  public static final String SESSION_ID_VALUE = "jkashduwn98kjahsd7sdf";
  public static final String SESSION_ID_FULL_VALUE = STR."""
  \{SESSION_ID_VALUE}; \
  expires=Thu, 19 Sep 2024 20:24:56 GMT; \
  HttpOnly; \
  Max-Age=1209600; \
  Path=/; \
  SameSite=Lax""";

  public static final String SUCCESS = "success";

  private static final String ID_PLACEHOLDER = "{id}";
  private static final String GW_PLACEHOLDER = "{gw}";
  private static final int WIREMOCK_PORT = 8888;
  private static final String LOGIN_PROPERTY = "accounts.login";
  private static final String PASSWORD_PROPERTY = "accounts.password";
  private static final String API_URL_PROPERTY = """
      quarkus.rest-client\
      ."io.github.aj8gh.fplcrunch.client.FplApiClient"\
      .url""";
  private static final String ACCOUNT_URL_PROPERTY = """
      quarkus.rest-client\
      ."io.github.aj8gh.fplcrunch.client.FplAccountClient"\
      .url""";

  private static final WireMockServer WIRE_MOCK = new WireMockServer(WIREMOCK_PORT);

  @Override
  public Map<String, String> start() {
    WIRE_MOCK.start();
    return Map.of(
        API_URL_PROPERTY, WIRE_MOCK.baseUrl(),
        ACCOUNT_URL_PROPERTY, WIRE_MOCK.baseUrl(),
        LOGIN_PROPERTY, LOGIN_VALUE,
        PASSWORD_PROPERTY, PASSWORD_VALUE
    );
  }

  @Override
  public void stop() {
    WIRE_MOCK.stop();
  }

  @SneakyThrows
  public static void stubHappyPath(String path, Object body) {
    WIRE_MOCK.stubFor(get(urlEqualTo(API_BASE + path
        .replace(ID_PLACEHOLDER, valueOf(ID))
        .replace(GW_PLACEHOLDER, valueOf(GW))))
        .willReturn(okJson(MAPPER.writeValueAsString(body))));
  }

  public static void stubLoginPath() {
    WIRE_MOCK.stubFor(post(urlEqualTo(ACCOUNTS_BASE + LOGIN))
        .withFormParam(LOGIN_NAME, equalTo(LOGIN_VALUE))
        .withFormParam(PASSWORD_NAME, equalTo(PASSWORD_VALUE))
        .withFormParam(APP_NAME, equalTo(APP_VALUE))
        .withFormParam(REDIRECT_URI_NAME, equalTo(REDIRECT_URI_VALUE))
        .withHeader(ACCEPT_LANGUAGE, equalTo(ACCEPT_LANGUAGE_VALUE))
        .withHeader(USER_AGENT, equalTo(USER_AGENT_VALUE))
        .willReturn(status(FOUND)
            .withHeader(LOGIN_STATUS, SUCCESS)
            .withHeader(LOCATION, LOCATION_VALUE)
            .withHeader(SET_COOKIE, STR."\{SESSION_TOKEN}=\{SESSION_TOKEN_FULL_VALUE}")
            .withHeader(SET_COOKIE, STR."\{SESSION_ID}=\{SESSION_ID_FULL_VALUE}")));
  }
}
