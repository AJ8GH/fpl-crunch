package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.github.aj8gh.fplcrunch.client.model.response.element.ElementSummary;
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

    assertThat(when()
        .get(ApiPath.ELEMENT_SUMMARY, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(ElementSummary.class))
        .isEqualTo(Loader.elementSummary());
  }
}
