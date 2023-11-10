package ch.pricemeier.jcli;

import io.quarkus.test.junit.main.QuarkusMainIntegrationTest;
import org.junit.jupiter.api.Disabled;

/**
 * Runs the same tests as CLITest but with the generated
 * jar / native executable!
 */
@Disabled
@QuarkusMainIntegrationTest
public class CLITestIT extends CLITest {
}
