package main.java.person;

import java.util.Locale;

public class Person {
    protected String secondName;
    protected String firstName;
    protected String lastName;
    protected String cardNumber;
    protected String accountNumber;
    protected double amountOfMoney;

    public Person(){

    }

    public Person(String secondName, String firstName, String lastName, String cardNumber, String accountNumber, double amountOfMoney) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.amountOfMoney = amountOfMoney;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getFullNameLowerCase(){
        return secondName.toLowerCase(Locale.ROOT) + ' ' +
                firstName.toLowerCase(Locale.ROOT) + ' ' +
                lastName.toLowerCase(Locale.ROOT);
    }
    public String getFullNameUpperCase(){
        return secondName.toUpperCase() + ' ' +
                firstName.toUpperCase() + ' ' +
                lastName.toUpperCase();
    }
}
