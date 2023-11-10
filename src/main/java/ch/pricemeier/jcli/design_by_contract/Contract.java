package ch.pricemeier.jcli.design_by_contract;

public final class Contract {
    private Contract() {
        throw new UnsupportedOperationException();
    }
    public static void requires(final String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new ContractViolatedException();
        }
    }
}
