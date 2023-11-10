package ch.pricemeier.jcli;

import ch.pricemeier.jcli.commands.CommandFactory;
import ch.pricemeier.jcli.services.actions.ActionBackendService;
import ch.pricemeier.jcli.commands.actions.ActionCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import picocli.CommandLine;

/**
 * This is a so called 'command mode application' that is run and then exits.
 * Quarkus is much more than just a REST API framework :)))))
 * Shutdown is always initiated by the application main thread returning.
 * If you want to run some logic on startup, and then run like a normal application
 * (i.e. not exit) then you should call Quarkus.waitForExit from the main thread
 * (A non-command mode application is essentially just running an application
 * that just exits)
 */
@QuarkusMain(name ="app")
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands =
        {
                ActionCommand.class
        })
public class JCLIMain implements Runnable, QuarkusApplication {
    /**
     * Command line arguments can be passed to the application through
     * the -D flag with the property quarkus.args:
     * quarkus dev -Dquarkus.args=cmd-args
     */
    private final ActionBackendService actionBackendService;

    public JCLIMain(
            final ActionBackendService actionBackendService) {
        this.actionBackendService = actionBackendService;
    }

    @Override
    public void run() {
    }

    @Override
    public int run(String... args) {
        return new CommandLine(this, new CommandFactory(
                actionBackendService)).execute(args);
    }
}