package io.github.aj8gh.fplcrunch.api;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.github.aj8gh.fplcrunch.api.util.Loader.asType;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.github.aj8gh.fplcrunch.client.model.league.classic.ClassicLeagueStandings;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class ClassicLeagueStandingsResourceTest {

  @Test
  @SneakyThrows
  void getClassicLeagueStandings() {
    stubHappyPath(ClientPath.LEAGUES_CLASSIC_STANDINGS, Loader.classicLeagueStandings());

    var actual = given()
        .when()
        .get(ApiPath.LEAGUES_CLASSIC_STANDINGS, ID)
        .then()
        .assertThat()
        .statusCode(OK)
        .extract()
        .response()
        .prettyPrint();

    assertThat(asType(actual, ClassicLeagueStandings.class))
        .isEqualTo(Loader.classicLeagueStandings());
  }
}
