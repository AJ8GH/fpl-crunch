package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.ACCOUNTS_BASE;
import static io.github.aj8gh.fplcrunch.api.ApiPath.LOGIN;
import static io.github.aj8gh.fplcrunch.api.ApiPath.LOGIN_DEFAULT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import io.github.aj8gh.fplcrunch.api.model.request.LoginRequest;
import io.github.aj8gh.fplcrunch.client.ClientPath;
import io.github.aj8gh.fplcrunch.client.FplAccountClient;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Slf4j
@Path(ACCOUNTS_BASE)
public class AccountResource {

  private static final String REQUEST_MESSAGE = STR."\{ACCOUNTS_BASE}\{LOGIN} POST request received";
  private static final String RESPONSE_MESSAGE = STR."{} response received from \{ClientPath.ACCOUNTS_BASE}\{ClientPath.LOGIN}";
  private static final String DEBUG_RESPONSE_MESSAGE = STR."""
  \{ClientPath.ACCOUNTS_BASE}\{ClientPath.LOGIN}
  Response Headers: {}
  Response Cookies: {}""";

  @RestClient
  FplAccountClient client;

  @POST
  @Path(LOGIN)
  @Consumes(APPLICATION_JSON)
  @Produces(APPLICATION_FORM_URLENCODED)
  public Response login(LoginRequest request) {
    log.info(REQUEST_MESSAGE);
    return logAndReturn(client.login(request.login(), request.password()));
  }

  @POST
  @Path(LOGIN_DEFAULT)
  @Produces(APPLICATION_FORM_URLENCODED)
  public Response loginDefault() {
    log.info(REQUEST_MESSAGE);
    return logAndReturn(client.loginDefault());
  }

  private Response logAndReturn(Response response) {
    log.info(RESPONSE_MESSAGE, response.getStatus());
    log.debug(DEBUG_RESPONSE_MESSAGE, response.getHeaders(), response.getCookies());
    return response;
  }
}
