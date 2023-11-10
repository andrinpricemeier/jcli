package ch.pricemeier.jcli.services.actions;

import ch.pricemeier.jcli.design_by_contract.Contract;
import jakarta.enterprise.context.Dependent;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Dependent
public class ActionBackendService {
    @RestClient
    ActionBackendRestClient actionBackendRestClient;

    public void addAction(final String targetTable) {
        Contract.requires(targetTable);
        actionBackendRestClient.create(targetTable);
    }
}
