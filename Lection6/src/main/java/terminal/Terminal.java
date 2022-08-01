package main.java.terminal;

import main.java.account.Account;
import main.java.exceptions.AccountIsLockedException;
import main.java.exceptions.NotCcorrectAmountException;
import main.java.person.Person;

import java.util.List;

public interface Terminal {
    void logIn(Account account) throws AccountIsLockedException;
    void transferFromAccountToAccount(Account accountSender, Account accountReceiver, double amount) throws NotCcorrectAmountException;
    boolean checkCorrectnessAmount (int amount);
    Account searchCardByNumber(List<Person> users, String enteredNumberOfCard);
    boolean isExistCardWithNumber(List<Person> users, String enteredNumberOfCard);
    
}
