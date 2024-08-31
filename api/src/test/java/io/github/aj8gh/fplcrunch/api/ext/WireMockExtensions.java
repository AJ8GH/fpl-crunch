package io.github.aj8gh.fplcrunch.api.ext;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.github.aj8gh.fplcrunch.api.util.Model.MAPPER;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BASE;
import static java.lang.String.valueOf;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.github.aj8gh.fplcrunch.api.util.Model;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;
import lombok.SneakyThrows;

public class WireMockExtensions implements QuarkusTestResourceLifecycleManager {

  public static final int ELEMENT_ID = 99;

  private static final String ID_PLACEHOLDER = "{id}";
  private static final int WIREMOCK_PORT = 8888;
  private static final String TEST_URL_PROPERTY = """
      quarkus.rest-client\
      ."io.github.aj8gh.fplcrunch.client.FplClient"\
      .url""";

  private final WireMockServer wireMockServer = new WireMockServer(WIREMOCK_PORT);

  @Override
  public Map<String, String> start() {
    wireMockServer.start();
    stubExtensions();
    return Map.of(TEST_URL_PROPERTY, wireMockServer.baseUrl());
  }

  @Override
  public void stop() {
    wireMockServer.stop();
  }

  private void stubExtensions() {
    stubHappyPath(ClientPath.BOOTSTRAP_STATIC, Model.BOOTSTRAP);
    stubHappyPath(ClientPath.ELEMENT_SUMMARY, Model.ELEMENT_SUMMARY);
    stubHappyPath(ClientPath.FIXTURES, Model.FIXTURES);
  }

  @SneakyThrows
  private void stubHappyPath(String path, Object body) {
    wireMockServer
        .stubFor(get(urlEqualTo(BASE + path.replace(ID_PLACEHOLDER, valueOf(ELEMENT_ID))))
            .willReturn(okJson(MAPPER.writeValueAsString(body))));
  }
}
