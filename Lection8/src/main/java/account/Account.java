package account;


import java.util.Objects;

public class Account {

    private String accountNumber;
    private String pin;
    private double countOfMoney;
    private Currency currency;
    private boolean isBlocked;
    private int timeToUnlock;

    public Account(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.countOfMoney = 20_000;
        this.currency = Currency.RUBLE;
        this.isBlocked = false;
        this.timeToUnlock = 0;
    }

    public Account(String accountNumber, String pin, double countOfMoney, Currency currency) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.countOfMoney = countOfMoney;
        this.currency = currency;
        this.isBlocked = false;
        this.timeToUnlock = 0;
    }

    public boolean isCurrentAmountMoreThenTransfer(double amount) {
        if(countOfMoney >= amount) return true;
        return false;
    }

    @Override
    public String toString() {
        return "СЧЕТ: " + accountNumber +
                "\n\nСРЕДСТВ НА СЧЕТУ: " + countOfMoney +
                " " + currency.getRussian();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getCountOfMoney() {
        return countOfMoney;
    }

    public void setCountOfMoney(double countOfMoney) {
        this.countOfMoney = countOfMoney;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getTimeToUnlock() {
        return timeToUnlock;
    }

    public void setTimeToUnlock(int timeToUnlock) {
        this.timeToUnlock = timeToUnlock;
    }

}
