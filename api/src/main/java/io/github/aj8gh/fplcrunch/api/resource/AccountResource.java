package io.github.aj8gh.fplcrunch.api.resource;

import static io.github.aj8gh.fplcrunch.api.ApiPath.Login.BASE;
import static io.github.aj8gh.fplcrunch.api.ApiPath.Login.DEFAULT;
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
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Slf4j
@Path(BASE)
@Produces(APPLICATION_FORM_URLENCODED)
public class AccountResource {

  private static final String REQUEST_MESSAGE = STR."\{BASE} POST request received";
  private static final String RESPONSE_MESSAGE = STR."{} response received from \{ClientPath.ACCOUNTS_BASE}\{ClientPath.LOGIN}";
  private static final String DEBUG_RESPONSE_MESSAGE = STR."""
  \{ClientPath.ACCOUNTS_BASE}\{ClientPath.LOGIN}
  Response Headers: {}
  Response Cookies: {}""";


  @ConfigProperty(name = "accounts.login")
  String login;

  @ConfigProperty(name = "accounts.password")
  String pw;

  @RestClient
  FplAccountClient client;

  @POST
  @Consumes(APPLICATION_JSON)
  public Response login(LoginRequest request) {
    log.info(REQUEST_MESSAGE);
    return logAndReturn(client.login(request.login(), request.password()));
  }

  @POST
  @Path(DEFAULT)
  public Response loginDefault() {
    log.info(STR."\{REQUEST_MESSAGE} LOGIN: \{login}, pw: \{pw}");
    return logAndReturn(client.loginDefault());
  }

  private Response logAndReturn(Response response) {
    log.info(RESPONSE_MESSAGE, response.getStatus());
    log.debug(DEBUG_RESPONSE_MESSAGE, response.getHeaders(), response.getCookies());
    return response;
  }
}
