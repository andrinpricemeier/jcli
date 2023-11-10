package ch.pricemeier.jcli.printing;

public final class ShellPrinter {
    public static void printSuccess(final String message) {
        final String result = "Success! " + message;
        System.out.println(result);
    }
}
