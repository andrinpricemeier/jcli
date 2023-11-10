package ch.pricemeier.jcli;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * This is effectively the same as running the JCLIMain application main directly,
 * but has the advantage it can be run from the IDE.
 * If a class that implements QuarkusApplication and has a Java main then the Java main will be run.
 *
 * CLI:
 * ./jcli action add name
 * ./jcli --version
 * ./jcli --help / ?
 *
 * See: https://quarkus.io/guides/picocli#native-mode-support
 * See: https://clig.dev/#guidelines
 * See: https://picocli.info/
 *
 *
 *  Idea: could add a natural language CLI:
 *  "can jCLI do X?" -> see: https://stackoverflow.com/questions/144339/what-would-the-best-tool-to-create-a-natural-dsl-in-java
 */
@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(JCLIMain.class, args);
    }
}