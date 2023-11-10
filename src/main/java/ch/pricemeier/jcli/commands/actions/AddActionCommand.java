package ch.pricemeier.jcli.commands.actions;

import ch.pricemeier.jcli.printing.ShellPrinter;
import ch.pricemeier.jcli.services.actions.ActionBackendService;
import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Adds a new action")
public class AddActionCommand implements Runnable {

    private final ActionBackendService actionBackendService;

    public AddActionCommand(final ActionBackendService actionBackendService) {
        this.actionBackendService = actionBackendService;
    }

    @CommandLine.Option(names = { "-t", "--table" }, paramLabel = "TABLE", description = "the target table this action applies to")
    String table;

    @Override
    public void run() {
        actionBackendService.addAction(table);
        ShellPrinter.printSuccess("Action for " + table + " added!");
    }
}