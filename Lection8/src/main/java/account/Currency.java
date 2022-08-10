package account;

public enum Currency {
    DOLLAR("ДОЛЛАР"),
    EURO("ЕВРО"),
    RUBLE("РУБ");

    private final String translation;

    Currency(String translation) {
        this.translation = translation;
    }

    public String getRussian() {
        return translation;
    }
}
