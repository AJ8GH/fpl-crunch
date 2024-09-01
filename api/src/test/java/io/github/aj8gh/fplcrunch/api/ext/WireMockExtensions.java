package io.github.aj8gh.fplcrunch.api.ext;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.github.aj8gh.fplcrunch.api.util.Loader.MAPPER;
import static io.github.aj8gh.fplcrunch.client.ClientPath.BASE;
import static java.lang.String.valueOf;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;
import lombok.SneakyThrows;

public class WireMockExtensions implements QuarkusTestResourceLifecycleManager {

  public static final int ID = 99;

  private static final String ID_PLACEHOLDER = "{id}";
  private static final int WIREMOCK_PORT = 8888;
  private static final String TEST_URL_PROPERTY = """
      quarkus.rest-client\
      ."io.github.aj8gh.fplcrunch.client.FplClient"\
      .url""";

  private static final WireMockServer WIRE_MOCK = new WireMockServer(WIREMOCK_PORT);

  @Override
  public Map<String, String> start() {
    WIRE_MOCK.start();
    return Map.of(TEST_URL_PROPERTY, WIRE_MOCK.baseUrl());
  }

  @Override
  public void stop() {
    WIRE_MOCK.stop();
  }

  @SneakyThrows
  public static void stubHappyPath(String path, Object body) {
    WIRE_MOCK
        .stubFor(get(urlEqualTo(BASE + path.replace(ID_PLACEHOLDER, valueOf(ID))))
            .willReturn(okJson(MAPPER.writeValueAsString(body))));
  }
}
