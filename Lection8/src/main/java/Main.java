import account.Account;
import exceptions.AccountIsLockedException;
import exceptions.AccountNotExistException;
import exceptions.NotCcorrectAmountException;
import exceptions.NotEnoughMoneyOnAccountException;
import person.Person;
import terminal.TerminalImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AccountIsLockedException {
        List<Account> account1 = new ArrayList<>();
        account1.add(new Account("2365 5677 2343 4344", "1234"));
        account1.add(new Account("3445 8678 8796 0968", "2222"));

        Person person1 = new Person(
                "Житарчук",
                "Мария",
                "Геннадьевна",
                account1
        );

        List<Account> account2 = new ArrayList<>();
        account2.add(new Account("2343 4344 2365 5677", "1234"));
        account2.add(new Account("8796 0968 3445 8678", "2222"));

        Person person2 = new Person(
                "Житарчук",
                "Бася",
                "Геннадьевна",
                account2
        );

        List<Person> users = new ArrayList<>();
        users.add(person1);
        users.add(person2);

        Scanner scanner = new Scanner(System.in);
        TerminalImpl terminal = null;
        Account chosenAccount = null;
        boolean logIn = false;

        try {
            System.out.println(person1.getName() + ", добро пожаловать! Для осуществления перевода выберите счет: ");
            for (int i = 1; i <= person1.getAccountsList().size(); i++) {
                System.out.printf("\n" + i + " - " + person1.getAccountsList().get(i - 1).getAccountNumber());
            }
            int chosenAccountIndex = scanner.nextInt();

            chosenAccount = person1.getAccountsList().get(chosenAccountIndex - 1);
            try {
                while (!logIn) {
                    if (!chosenAccount.isBlocked()) {
                        terminal = new TerminalImpl(chosenAccount);
                        boolean isPinValid = false;

                        while (!isPinValid && terminal.getPinValidator().getData() == null) {
                            terminal.logIn(chosenAccount);
                            isPinValid = terminal.isLogIn();
                        }
                        if (terminal.getPinValidator().getData() == null && isPinValid) {
                            logIn = true;
                        }
                    }
                }
            } catch (AccountIsLockedException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Введите номер счета зачисления: ");
            String accountReceiverNumber = new Scanner(System.in).nextLine();
            if (terminal.isExistCardWithNumber(users, accountReceiverNumber)) {
                while (true) {
                    System.out.println("Введите сумму перевода: ");
                    int amountTransfer = new Scanner(System.in).nextInt();
                    try {
                        Account accountReceive = terminal.searchCardByNumber(users, accountReceiverNumber);

                        terminal.transferFromAccountToAccount(chosenAccount, accountReceive, amountTransfer);
                        System.out.println("Перевод выполнен успешно. \nСредств на счету списания: " +
                                chosenAccount.getCountOfMoney() + "\nСредств на счету зачисления: " +
                                accountReceive.getCountOfMoney());
                        break;
                    } catch (NotEnoughMoneyOnAccountException | NotCcorrectAmountException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                }
            } else throw new AccountNotExistException();
        } catch (AccountNotExistException e) {
            System.out.println(e.getMessage());
        }
    }
}