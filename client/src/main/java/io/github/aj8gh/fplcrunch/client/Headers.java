package io.github.aj8gh.fplcrunch.client;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Headers {

  public static final String LOGIN_STATUS = "pl-login";
  public static final String USER_AGENT_VALUE = """
      Mozilla/5.0 (Windows NT 10.0; Win64;  x64) \
      AppleWebKit/537.36 (KHTML, like Gecko) \
      Chrome/58.0.3029.110 \
      Safari/537.3""";
  public static final String ACCEPT_LANGUAGE_VALUE = "en-US,en;q=0.5";
}
