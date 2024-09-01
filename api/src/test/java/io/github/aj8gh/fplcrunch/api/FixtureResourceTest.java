package io.github.aj8gh.fplcrunch.api;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.github.aj8gh.fplcrunch.api.util.Loader.asType;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.github.aj8gh.fplcrunch.client.model.fixture.Fixture;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class FixtureResourceTest {

  @Test
  @SneakyThrows
  void getFixtures() {
    stubHappyPath(ClientPath.FIXTURES, Loader.fixtures());

    var actual = given()
        .when()
        .get(ApiPath.FIXTURES)
        .then()
        .assertThat()
        .statusCode(OK)
        .extract()
        .response()
        .prettyPrint();

    assertThat(asType(actual, new TypeReference<List<Fixture>>() {
    })).isEqualTo(Loader.fixtures());
  }
}
