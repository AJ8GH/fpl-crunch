package io.github.aj8gh.fplcrunch.api.util;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import io.github.aj8gh.fplcrunch.client.model.element.ElementSummary;
import io.github.aj8gh.fplcrunch.client.model.entry.summary.Entry;
import io.github.aj8gh.fplcrunch.client.model.fixture.Fixture;
import java.util.List;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Loader {

  public static final ObjectMapper MAPPER = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(WRITE_DATES_AS_TIMESTAMPS, false)
      .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

  private static final String ENTRY_JSON = "entry.json";
  private static final String BOOTSTRAP_JSON = "bootstrap-static.json";
  private static final String ELEMENT_SUMMARY_JSON = "element-summary.json";
  private static final String FIXTURES_JSON = "fixtures.json";

  public static Entry entry() {
    return load(ENTRY_JSON, Entry.class);
  }

  public static Bootstrap bootstrapStatic() {
    return load(BOOTSTRAP_JSON, Bootstrap.class);
  }

  public ElementSummary elementSummary() {
    return load(ELEMENT_SUMMARY_JSON, ElementSummary.class);
  }

  public List<Fixture> fixtures() {
    return load(FIXTURES_JSON, new TypeReference<>() {
    });
  }

  @SneakyThrows
  public static <T> T asType(String json, Class<T> type) {
    return MAPPER.readValue(json, type);
  }

  @SneakyThrows
  public static <T> T asType(String json, TypeReference<T> type) {
    return MAPPER.readValue(json, type);
  }

  @SneakyThrows
  private static <T> T load(String file, Class<T> type) {
    return MAPPER.readValue(
        Loader.class.getClassLoader().getResourceAsStream(file),
        type);
  }

  @SneakyThrows
  private static <T> T load(String file, TypeReference<T> type) {
    return MAPPER.readValue(
        Loader.class.getClassLoader().getResourceAsStream(file),
        type);
  }
}
