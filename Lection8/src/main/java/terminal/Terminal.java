package terminal;

import account.Account;
import exceptions.AccountIsLockedException;
import exceptions.NotCcorrectAmountException;
import person.Person;

import java.io.IOException;
import java.util.List;

public interface Terminal {
    void logIn(Account account) throws AccountIsLockedException, IOException;
    void transferFromAccountToAccount(Account accountSender, Account accountReceiver, double amount) throws NotCcorrectAmountException;
    boolean checkCorrectnessAmount (int amount);
    Account searchCardByNumber(List<Person> users, String enteredNumberOfCard);
    boolean isExistCardWithNumber(List<Person> users, String enteredNumberOfCard);
    
}
