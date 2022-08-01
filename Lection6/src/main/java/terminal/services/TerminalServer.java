package main.java.terminal.services;

import main.java.account.Account;
import main.java.exceptions.AccountIsLockedException;
import main.java.exceptions.NotEnoughMoneyOnAccountException;

public class TerminalServer {
    public boolean isEnoughMoney(Account account, double amount)
            throws NotEnoughMoneyOnAccountException {
        if (account.isCurrentAmountMoreThenTransfer(amount)){
            return true;
        }
        else throw new NotEnoughMoneyOnAccountException();
    }
}