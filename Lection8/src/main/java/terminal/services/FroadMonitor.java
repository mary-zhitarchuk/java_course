package terminal.services;

import account.Account;
import exceptions.NotCcorrectAmountException;

public class FroadMonitor {
    private final int MULTIPLE = 100;

    public boolean isOperationAvailable(double amount) throws NotCcorrectAmountException {
        if (isOperationMultiple(amount)) {
            return true;
        } else throw new NotCcorrectAmountException();
    }

    private boolean isOperationMultiple(double amount){
        return amount % MULTIPLE == 0;
    }
}
