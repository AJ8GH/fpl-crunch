package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.LOCATION_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.PL_PROFILE_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.SESSION_ID_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.SUCCESS;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubLoginPath;
import static io.github.aj8gh.fplcrunch.client.Cookies.PL_PROFILE;
import static io.github.aj8gh.fplcrunch.client.Cookies.SESSION_ID;
import static io.github.aj8gh.fplcrunch.client.Headers.LOGIN_STATUS;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static jakarta.ws.rs.core.HttpHeaders.LOCATION;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.FOUND;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ApiPath.Login;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.request.LoginRequest;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class AccountResourceTest {

  @ConfigProperty(name = "accounts.login")
  private String loginValue;
  @ConfigProperty(name = "accounts.password")
  private String passwordValue;

  @Test
  void login() {
    var request = request();
    stubLoginPath(request);

    given()
        .accept(ContentType.ANY)
        .contentType(APPLICATION_JSON)
        .body(request)
        .when()
        .post(ApiPath.API + Login.BASE)
        .then()
        .statusCode(FOUND)
        .header(LOCATION, LOCATION_VALUE)
        .header(LOGIN_STATUS, SUCCESS)
        .cookie(SESSION_ID, SESSION_ID_VALUE)
        .cookie(PL_PROFILE, PL_PROFILE_VALUE);
  }

  @Test
  void loginDefault() {
    stubLoginPath(request());

    when()
        .post(ApiPath.API + Login.BASE + Login.DEFAULT)
        .then()
        .statusCode(FOUND)
        .header(LOCATION, LOCATION_VALUE)
        .header(LOGIN_STATUS, SUCCESS)
        .cookie(SESSION_ID, SESSION_ID_VALUE)
        .cookie(PL_PROFILE, PL_PROFILE_VALUE);
  }

  private LoginRequest request() {
    return LoginRequest.builder()
        .login(loginValue)
        .password(passwordValue)
        .build();
  }
}
