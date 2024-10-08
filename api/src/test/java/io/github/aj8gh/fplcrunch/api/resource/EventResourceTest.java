package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.GW;
import static io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions.stubHappyPath;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

import io.github.aj8gh.fplcrunch.api.ApiPath;
import io.github.aj8gh.fplcrunch.api.ApiPath.Event;
import io.github.aj8gh.fplcrunch.api.ext.WireMockExtensions;
import io.github.aj8gh.fplcrunch.api.model.response.event.EventResponse;
import io.github.aj8gh.fplcrunch.api.model.response.event.live.EventLiveResponse;
import io.github.aj8gh.fplcrunch.api.util.Loader;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import org.junit.jupiter.api.Test;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
class EventResourceTest {

  @Test
  void getLive() {
    stubHappyPath(ClientPath.EVENT_LIVE);

    assertThat(when()
        .get(ApiPath.API + Event.EVENT_LIVE, GW)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(EventLiveResponse.class))
        .usingRecursiveComparison()
        .isEqualTo(Loader.eventLive());
  }

  @Test
  void getEvents() {
    stubHappyPath(ClientPath.EVENTS);

    assertThat(when()
        .get(ApiPath.API + Event.EVENTS)
        .then()
        .statusCode(OK)
        .extract()
        .response()
        .as(new TypeRef<List<EventResponse>>() {
        })).usingRecursiveComparison()
        .isEqualTo(Loader.events());
  }
}
