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
import io.github.aj8gh.fplcrunch.client.model.element.ElementSummary;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class ElementResourceTest {

  @Test
  @SneakyThrows
  void getElementSummary() {
    stubHappyPath(ClientPath.ELEMENT_SUMMARY, Loader.elementSummary());

    var actual = given()
        .when()
        .get(ApiPath.ELEMENT_SUMMARY, ID)
        .then()
        .assertThat()
        .statusCode(OK)
        .extract()
        .response()
        .getBody()
        .prettyPrint();

    assertThat(asType(actual, ElementSummary.class))
        .isEqualTo(Loader.elementSummary());
  }
}
