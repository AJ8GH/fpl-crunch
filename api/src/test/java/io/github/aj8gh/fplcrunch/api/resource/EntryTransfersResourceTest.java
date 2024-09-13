package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.entry.transfer.EntryTransferResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class EntryTransfersResourceTest {

  @Test
  @SneakyThrows
  void getEntryTransfers() {
    stubHappyPath(ClientPath.ENTRY_TRANSFERS);

    assertThat(when()
        .get(ApiPath.ENTRY_TRANSFERS, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<EntryTransferResponse>>() {
        })).usingRecursiveComparison()
        .isEqualTo(Loader.entryTransfers());
  }
}
