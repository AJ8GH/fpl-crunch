package io.github.aj8gh.fplcrunch.api;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.github.aj8gh.fplcrunch.api.util.Loader.asType;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.github.aj8gh.fplcrunch.client.model.entry.transfer.EntryTransfer;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class EntryTransfersResourceTest {

  @Test
  @SneakyThrows
  void getEntryTransfers() {
    stubHappyPath(ClientPath.ENTRY_TRANSFERS, Loader.entryTransfers());

    var actual = given()
        .when()
        .get(ApiPath.ENTRY_TRANSFERS, ID)
        .then()
        .assertThat()
        .statusCode(OK)
        .extract()
        .response()
        .prettyPrint();

    assertThat(asType(actual, new TypeReference<List<EntryTransfer>>() {
    })).isEqualTo(Loader.entryTransfers());
  }
}
