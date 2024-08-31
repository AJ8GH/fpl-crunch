package io.github.aj8gh.fplcrunch.api;

import static io.github.aj8gh.fplcrunch.api.Model.MAPPER;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class BootstrapResourceTest {

  @Test
  @SneakyThrows
  void getBootstrap() {
    var actual = given()
        .when()
        .get(ApiPath.BOOTSTRAP)
        .then()
        .assertThat()
        .statusCode(OK)
        .extract()
        .response()
        .print();

    assertThat(MAPPER.readValue(actual, Bootstrap.class))
        .isEqualTo(Model.BOOTSTRAP);
  }
}
