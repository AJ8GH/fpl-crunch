package io.github.aj8gh.fplcrunch.api.util;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import io.github.aj8gh.fplcrunch.client.model.element.ElementSummary;
import io.github.aj8gh.fplcrunch.client.model.fixture.Fixture;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.instancio.Instancio;
import org.instancio.TypeToken;

@UtilityClass
public class Model {

  public static final ObjectMapper MAPPER = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(WRITE_DATES_AS_TIMESTAMPS, false);

  public static final Bootstrap BOOTSTRAP = Instancio.create(Bootstrap.class);
  public static final ElementSummary ELEMENT_SUMMARY = Instancio.create(ElementSummary.class);
  public static final List<Fixture> FIXTURES = Instancio.create(new TypeToken<>() {
  });
}
