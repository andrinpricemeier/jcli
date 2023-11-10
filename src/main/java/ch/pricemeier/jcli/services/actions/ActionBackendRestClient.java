package ch.pricemeier.jcli.services.actions;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * More info here: https://quarkus.io/guides/rest-client-reactive
 *
 * Can also use QuarkusRestClientBuilder to programmatically build the rest client.
 */
@Path("/actions")
// Instead of having to specify the fully qualified package name,
// we can make up a name. This allows us to move this class wherever we like
// Without having to amend/change the config file each time.
@RegisterRestClient(configKey="backend_access_service")
@Produces("application/json")
@Consumes("application/json")
public interface ActionBackendRestClient {
    @POST
    void create(String targetTable);
}
