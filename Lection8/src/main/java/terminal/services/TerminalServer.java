package terminal.services;

import account.Account;
import exceptions.AccountIsLockedException;
import exceptions.NotEnoughMoneyOnAccountException;

public class TerminalServer {

    public boolean isEnoughMoney(Account account, double amount) throws NotEnoughMoneyOnAccountException {
        if (account.isCurrentAmountMoreThenTransfer(amount)){
            return true;
        }
        else throw new NotEnoughMoneyOnAccountException();
    }
}