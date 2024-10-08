package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.QUERY_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.github.aj8gh.fplcrunch.client.QueryParams.EVENT;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.fixture.FixtureResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class FixtureResourceTest {

  @Test
  void getFixtures() {
    stubHappyPath(ClientPath.FIXTURES);

    assertThat(when()
        .get(ApiPath.API + ApiPath.FIXTURES)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<FixtureResponse>>() {
        })).usingRecursiveComparison()
        .isEqualTo(Loader.fixtures());
  }

  @Test
  void getFixturesPaginated() {
    stubHappyPath(ClientPath.FIXTURES, EVENT, QUERY_VALUE);

    assertThat(given()
        .queryParam(EVENT, QUERY_VALUE)
        .when()
        .get(ApiPath.API + ApiPath.FIXTURES)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<FixtureResponse>>() {
        })).usingRecursiveComparison()
        .isEqualTo(Loader.fixturesPaginated());
  }
}
