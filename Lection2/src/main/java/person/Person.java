package main.java.person;

public class Person {
    public String secondName;
    public String firstName;
    public String lastName;
    public String cardNumber;
    public String accountNumber;
    public double amountOfMoney;
    public boolean uppercase;

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

    @Override
    public String toString() {
        if(uppercase)
        {
            return secondName.toUpperCase() + ' ' +
                    firstName.toUpperCase() + ' ' +
                    lastName.toUpperCase();
        }
        return secondName + ' ' +
               firstName + ' ' +
               lastName;
    }
}
