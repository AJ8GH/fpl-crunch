package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.QUERY_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.github.aj8gh.fplcrunch.client.QueryParams.PAGE_STANDINGS;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ApiPath.Leagues;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.league.classic.ClassicLeagueStandingsResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class ClassicLeagueResourceTest {

  @Test
  void getClassicLeagueStandings() {
    stubHappyPath(ClientPath.LEAGUES_CLASSIC_STANDINGS);

    assertThat(when()
        .get(ApiPath.API + Leagues.LEAGUES_CLASSIC + Leagues.STANDINGS, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(ClassicLeagueStandingsResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.classicLeagueStandings());
  }

  @Test
  void getClassicLeagueStandingsPaginated() {
    stubHappyPath(ClientPath.LEAGUES_CLASSIC_STANDINGS, PAGE_STANDINGS, QUERY_VALUE);

    assertThat(given()
        .queryParam(PAGE_STANDINGS, QUERY_VALUE)
        .when()
        .get(ApiPath.API + Leagues.LEAGUES_CLASSIC + Leagues.STANDINGS, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(ClassicLeagueStandingsResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.classicLeagueStandingsPaginated());
  }
}
