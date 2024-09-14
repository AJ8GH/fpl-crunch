package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.Login.BASE;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Login.DEFAULT;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.LOCATION_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.LOGIN_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.PASSWORD_VALUE;
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

import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.request.LoginRequest;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class AccountResourceTest {

  @Test
  void login() {
    stubLoginPath();
    var request = LoginRequest.builder()
        .login(LOGIN_VALUE)
        .password(PASSWORD_VALUE)
        .build();

    given()
        .accept(ContentType.ANY)
        .contentType(APPLICATION_JSON)
        .body(request)
        .when()
        .post(BASE)
        .then()
        .statusCode(FOUND)
        .header(LOCATION, LOCATION_VALUE)
        .header(LOGIN_STATUS, SUCCESS)
        .cookie(SESSION_ID, SESSION_ID_VALUE)
        .cookie(PL_PROFILE, PL_PROFILE_VALUE);
  }

  @Test
  void loginDefault() {
    stubLoginPath();

    when()
        .post(BASE + DEFAULT)
        .then()
        .statusCode(FOUND)
        .header(LOCATION, LOCATION_VALUE)
        .header(LOGIN_STATUS, SUCCESS)
        .cookie(SESSION_ID, SESSION_ID_VALUE)
        .cookie(PL_PROFILE, PL_PROFILE_VALUE);
  }
}
