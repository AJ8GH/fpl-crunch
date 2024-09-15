package io.github.aj8gh.fplcrunch.api.resource;

import io.github.aj8gh.fplcrunch.client.FplApiClient;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public abstract class AbstractResource {

  @RestClient
  protected FplApiClient client;

  protected Response ok(Object object) {
    return Response.ok(object).build();
  }

  protected Map<String, Integer> query(String name, Integer value) {
    return Optional.ofNullable(value)
        .map(val -> Map.of(name, val))
        .orElseGet(HashMap::new);
  }
}
