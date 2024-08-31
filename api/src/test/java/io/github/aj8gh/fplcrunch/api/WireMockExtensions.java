package io.github.aj8gh.fplcrunch.api;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.github.aj8gh.fplcrunch.api.Model.BOOTSTRAP;
import static io.github.aj8gh.fplcrunch.api.Model.MAPPER;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BOOTSTRAP_STATIC;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;
import lombok.SneakyThrows;

public class WireMockExtensions implements QuarkusTestResourceLifecycleManager {

  private static final String TEST_URL_PROPERTY = """
      quarkus.rest-client\
      ."io.github.aj8gh.fplcrunch.client.FplClient"\
      .url""";

  private static final int WIREMOCK_PORT = 8888;

  private final WireMockServer wireMockServer = new WireMockServer(WIREMOCK_PORT);

  @Override
  public Map<String, String> start() {
    wireMockServer.start();
    stubExtensions();
    return Map.of(TEST_URL_PROPERTY, wireMockServer.baseUrl() + BASE);
  }

  @Override
  public void stop() {
    wireMockServer.stop();
  }

  @SneakyThrows
  private void stubExtensions() {
    wireMockServer
        .stubFor(get(urlEqualTo(BASE + BOOTSTRAP_STATIC))
            .willReturn(okJson(MAPPER.writeValueAsString(BOOTSTRAP))));
  }
}
