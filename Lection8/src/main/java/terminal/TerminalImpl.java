package terminal;

import account.Account;
import exceptions.NotCcorrectAmountException;
import exceptions.NotEnoughMoneyOnAccountException;
import person.Person;
import terminal.services.FroadMonitor;
import terminal.services.PinValidator;
import terminal.services.TerminalServer;
import exceptions.AccountIsLockedException;
import exceptions.NotLogInException;

import java.io.IOException;
import java.util.List;

public class TerminalImpl implements Terminal {
    private final TerminalServer terminalServer;
    private final PinValidator pinValidator;
    private final FroadMonitor froadMonitor;
    private Account account;
    private boolean isLogIn;

    public TerminalImpl(Account account) {
        this.account = account;
        this.terminalServer = new TerminalServer();
        this.pinValidator = new PinValidator();
        this.froadMonitor = new FroadMonitor();
    }

    @Override
    public void logIn(Account account) throws AccountIsLockedException, IOException {
        isLogIn = pinValidator.isPinValid(account);
    }

    @Override
    public void transferFromAccountToAccount(Account accountSender, Account accountReceiver, double amount) throws NotCcorrectAmountException {
        if(isLogIn) {
            if (!terminalServer.isEnoughMoney(accountSender, amount))
                throw new NotEnoughMoneyOnAccountException();
            if (!froadMonitor.isOperationAvailable(amount))
                throw new NotCcorrectAmountException();
            else {
                accountSender.setCountOfMoney(accountSender.getCountOfMoney() - amount);
                accountReceiver.setCountOfMoney(accountReceiver.getCountOfMoney() + amount);
            }
        }
        else throw new NotLogInException();
    }

    @Override
    public Account searchCardByNumber(List<Person> users, String enteredNumberOfCard) {
        for(Person user : users){
            for (Account account : user.getAccountsList()) {
                if(account.getAccountNumber().equals(enteredNumberOfCard))
                    return account;
            }
        }
        return null;
    }

    @Override
    public boolean isExistCardWithNumber(List<Person> users, String enteredNumberOfCard) {
        return searchCardByNumber(users, enteredNumberOfCard) != null;
    }

    @Override
    public boolean checkCorrectnessAmount(int amount) {
        if(amount % 100 == 0){
            return true;
        }
        return false;
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public void setLogIn(boolean logIn) {
        isLogIn = logIn;
    }

    public TerminalServer getTerminalServer() {
        return terminalServer;
    }

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    public FroadMonitor getFroadMonitor() {
        return froadMonitor;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
