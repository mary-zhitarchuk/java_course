package person;

import account.Account;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String name;
    private String lastName;
    private List<Account> accountsList = new ArrayList<>();

    public Person(String firstName, String name, String lastName, List<Account> accountsList) {
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.accountsList = accountsList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(ArrayList<Account> accountsList) {
        this.accountsList = accountsList;
    }
}
