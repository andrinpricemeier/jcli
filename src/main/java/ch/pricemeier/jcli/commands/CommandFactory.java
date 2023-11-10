package ch.pricemeier.jcli.commands;

import ch.pricemeier.jcli.commands.actions.AddActionCommand;
import ch.pricemeier.jcli.services.actions.ActionBackendService;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

public class CommandFactory implements IFactory {
    IFactory fallback = CommandLine.defaultFactory();
    private final ActionBackendService actionBackendService;

    public CommandFactory(final ActionBackendService actionBackendService) {
        this.actionBackendService = actionBackendService;
    }

    @Override
    public <K> K create(Class<K> cls) throws Exception {
        if (cls == AddActionCommand.class) {
            return (K) new AddActionCommand(actionBackendService);
        }

        return fallback.create(cls);
    }
}
