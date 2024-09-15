package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.GW;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.ID;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.PL_PROFILE_VALUE;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubAuthenticatedHappyPath;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.github.aj8gh.fplcrunch.client.Cookies.PL_PROFILE;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ApiPath.Entry;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.entry.history.EntryHistoryResponse;
import io.github.aj8gh.fplcrunch.api.model.response.entry.pick.EntryPicksResponse;
import io.github.aj8gh.fplcrunch.api.model.response.entry.summary.EntryResponse;
import io.github.aj8gh.fplcrunch.api.model.response.entry.transfer.EntryTransferResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class EntryResourceTest {

  @Test
  void getEntry() {
    stubHappyPath(ClientPath.ENTRY);

    assertThat(when()
        .get(ApiPath.API + Entry.BASE, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(EntryResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.entry());
  }

  @Test
  void getEntryHistory() {
    stubHappyPath(ClientPath.ENTRY_HISTORY);

    assertThat(when()
        .get(ApiPath.API + Entry.BASE + Entry.HISTORY, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(EntryHistoryResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.entryHistory());
  }

  @Test
  void getEntryPicks() {
    stubHappyPath(ClientPath.ENTRY_PICKS);

    assertThat(when()
        .get(ApiPath.API + Entry.BASE + Entry.PICKS, ID, GW)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(EntryPicksResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.entryPicks());
  }

  @Test
  void getEntryTransfers() {
    stubHappyPath(ClientPath.ENTRY_TRANSFERS);

    assertThat(when()
        .get(ApiPath.API + Entry.BASE + Entry.TRANSFERS, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<EntryTransferResponse>>() {
        })).usingRecursiveComparison()
        .isEqualTo(Loader.entryTransfers());
  }

  @Test
  void getEntryTransfersLatest() {
    stubAuthenticatedHappyPath(ClientPath.ENTRY_TRANSFERS_LATEST);

    assertThat(given()
        .cookie(PL_PROFILE, PL_PROFILE_VALUE)
        .when()
        .get(ApiPath.API + Entry.BASE + Entry.TRANSFERS_LATEST, ID)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<EntryTransferResponse>>() {
        })).usingRecursiveComparison()
        .isEqualTo(Loader.entryTransfersLatest());
  }
}
