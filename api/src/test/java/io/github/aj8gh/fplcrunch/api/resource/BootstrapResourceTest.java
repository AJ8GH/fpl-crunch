package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.bootstrap.BootstrapResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class BootstrapResourceTest {

  @Test
  void getBootstrap() {
    stubHappyPath(ClientPath.BOOTSTRAP_STATIC);

    assertThat(when()
        .get(ApiPath.API + ApiPath.BOOTSTRAP)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(BootstrapResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.bootstrapStatic());
  }
}
