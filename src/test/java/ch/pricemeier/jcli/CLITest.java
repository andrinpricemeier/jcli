package ch.pricemeier.jcli;

import ch.pricemeier.jcli.services.actions.ActionBackendService;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainLauncher;
import io.quarkus.test.junit.main.QuarkusMainTest;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Singleton;
import org.junit.jupiter.api.*;
import java.util.Set;

/**
 * Each test method must be annotated with @Launch to automatically
 * start the application or have a QuarkusMainLauncher parameter to
 * manually launch the application.
 * CDI injection is not supported in the @QuarkusMainTest tests.
 * Consequently, mocking CDI beans with QuarkusMock or @InjectMock
 * is not supported either.
 * It is possible to mock CDI beans by leveraging test profiles though.
 * See: https://quarkus.io/guides/command-mode-reference#mocking
 */
@Disabled
@QuarkusMainTest
@TestProfile(CLITest.CLITestProfile.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CLITest {
    @Test
    @Launch(value = { "action", "add" })
    public void role_show_works(LaunchResult result) {
        final var output = result.getOutput();
        Assertions.assertEquals("Success!", output);
    }

    @Disabled
    @Test
    @Launch(value = {}, exitCode = 1)
    public void testLaunchCommandFailed() {
        // TODO: test this
    }

    @Test
    public void testManualLaunch(QuarkusMainLauncher launcher) {
        LaunchResult result = launcher.launch("action", "add");
        Assertions.assertEquals(0, result.exitCode());
        Assertions.assertTrue(result.getOutput().contains("Success!"));
    }

    public static class CLITestProfile implements QuarkusTestProfile {
        @Override
        public Set<Class<?>> getEnabledAlternatives() {
            return Set.of(
                    ActionBackendServiceMock.class);
        }
    }

    @Alternative
    @Singleton
    public static class ActionBackendServiceMock extends ActionBackendService {
    }
}
