package main.java.enums;

public enum Currency {
    DOLLAR("ДОЛЛАР"),
    EURO("ЕВРО"),
    RUB("РУБ");

    private final String translation;

    Currency(String translation) {
        this.translation = translation;
    }

    public String translate(){
        return translation;
    };
}