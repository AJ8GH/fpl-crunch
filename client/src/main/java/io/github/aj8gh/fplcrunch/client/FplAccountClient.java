package io.github.aj8gh.fplcrunch.client;

import static io.github.aj8gh.fplcrunch.client.ClientPath.ACCOUNTS_BASE;
import static io.github.aj8gh.fplcrunch.client.ClientPath.LOGIN;
import static io.github.aj8gh.fplcrunch.client.FormParams.APP_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.APP_VALUE;
import static io.github.aj8gh.fplcrunch.client.FormParams.LOGIN_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.PASSWORD_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.REDIRECT_URI_NAME;
import static io.github.aj8gh.fplcrunch.client.FormParams.REDIRECT_URI_VALUE;
import static io.github.aj8gh.fplcrunch.client.Headers.ACCEPT_LANGUAGE_VALUE;
import static io.github.aj8gh.fplcrunch.client.Headers.USER_AGENT_VALUE;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT_LANGUAGE;
import static jakarta.ws.rs.core.HttpHeaders.USER_AGENT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

import io.quarkus.rest.client.reactive.ClientFormParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;

@RegisterRestClient
@Path(ACCOUNTS_BASE)
@Consumes(APPLICATION_FORM_URLENCODED)
@Produces(APPLICATION_FORM_URLENCODED)
@ClientFormParam(name = APP_NAME, value = APP_VALUE)
@ClientFormParam(name = REDIRECT_URI_NAME, value = REDIRECT_URI_VALUE)
@ClientHeaderParam(name = USER_AGENT, value = USER_AGENT_VALUE)
@ClientHeaderParam(name = ACCEPT_LANGUAGE, value = ACCEPT_LANGUAGE_VALUE)
public interface FplAccountClient {

  @POST
  @Path(LOGIN)
  Response login(
      @RestForm(LOGIN_NAME) String login,
      @RestForm(PASSWORD_NAME) String password);

  @POST
  @Path(LOGIN)
  @ClientFormParam(name = LOGIN_NAME, value = "${accounts.login}")
  @ClientFormParam(name = PASSWORD_NAME, value = "${accounts.password}")
  Response loginDefault();
}
