package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.PL_PROFILE_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubAuthenticatedHappyPath;
import static io.github.aj8gh.fplcrunch.client.Cookies.PL_PROFILE;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.myteam.FplTeamResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class TeamResourceTest {

  @Test
  void getTeam() {
    stubAuthenticatedHappyPath(ClientPath.MY_TEAM);

    assertThat(given()
        .cookie(PL_PROFILE, PL_PROFILE_VALUE)
        .when()
        .get(ApiPath.API + ApiPath.MY_TEAM, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(FplTeamResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.fplTeam());
  }
}
