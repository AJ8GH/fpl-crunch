package io.github.aj8gh.fplcrunch.api;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aj8gh.fplcrunch.client.model.bootstrap.Bootstrap;
import lombok.experimental.UtilityClass;
import org.instancio.Instancio;

@UtilityClass
public class Model {

  public static final ObjectMapper MAPPER = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(WRITE_DATES_AS_TIMESTAMPS, false);

  public static final Bootstrap BOOTSTRAP = Instancio.create(Bootstrap.class);
}
