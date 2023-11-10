package ch.pricemeier.jcli.commands.actions;

import picocli.CommandLine;

@CommandLine.Command(name = "action", mixinStandardHelpOptions = true, subcommands =
        {
                AddActionCommand.class
        })
public class ActionCommand implements Runnable {
    @Override
    public void run() {
    }
}