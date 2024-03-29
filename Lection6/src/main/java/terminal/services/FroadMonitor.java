package main.java.terminal.services;

import main.java.account.Account;
import main.java.exceptions.NotCcorrectAmountException;

public class FroadMonitor {
    private final int MULTIPLE = 100;

    public boolean isOperationAvailable(double amount) throws NotCcorrectAmountException {
        if (amount % MULTIPLE == 0) {
            return true;
        } else throw new NotCcorrectAmountException();
    }
}
