package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.github.aj8gh.fplcrunch.client.model.response.fixture.Fixture;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
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

    assertThat(when()
        .get(ApiPath.FIXTURES)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<Fixture>>() {
        })).isEqualTo(Loader.fixtures());
  }
}
