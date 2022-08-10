package terminal;

import account.Account;
import exceptions.NotCcorrectAmountException;
import exceptions.NotEnoughMoneyOnAccountException;
import exceptions.NotLogInException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TerminalImplTest {
    private Account accountSender = new Account("2365 5677 2343 4344", "1234");
    private Account accountReciver = new Account("3445 8678 8796 0968", "2222");
    private Account accountBad = new Account("2365 5677 2343 4344", "12345");
    private TerminalImpl terminal = new TerminalImpl(accountSender);

    private static List<Account> account1 = new ArrayList<>();
    private static Person person1 = new Person(
            "Житарчук",
            "Мария",
            "Геннадьевна",
            account1
    );

    private static List<Account> account2 = new ArrayList<>();
    private static Person person2 = new Person(
            "Житарчук",
            "Бася",
            "Геннадьевна",
            account2
    );

    private static List<Person> users = new ArrayList<>();


    @Test
    public void testLogInOk() throws IOException {
        terminal.logIn(accountSender);
        Assert.assertEquals(true, terminal.isLogIn());
    }

    @Test
    public void testNotLogIn() throws IOException {
        terminal.logIn(accountBad);
        Assert.assertEquals(false, terminal.isLogIn());
    }

    @Test
    public void testTransferFromAccountToAccountOk() throws NotCcorrectAmountException, IOException {
        terminal.logIn(accountSender);
        terminal.transferFromAccountToAccount(accountSender, accountReciver, 2500);
    }

    @Test(expected = NotCcorrectAmountException.class)
    public void testNotCcorrectAmountException() throws NotCcorrectAmountException, IOException {
        terminal.logIn(accountSender);
        terminal.transferFromAccountToAccount(accountSender, accountReciver, 255);
    }

    @Test(expected = NotLogInException.class)
    public void testNotLogInException() throws NotCcorrectAmountException {
        terminal.setLogIn(false);
        terminal.transferFromAccountToAccount(accountSender, accountReciver, 255);
    }

    @Test(expected = NotEnoughMoneyOnAccountException.class)
    public void testNotEnoughMoneyOnAccountException() throws IOException, NotCcorrectAmountException {
        terminal.logIn(accountSender);
        terminal.transferFromAccountToAccount(accountSender, accountReciver, 100_000);
    }

    @BeforeClass
    public static void addListsOfAccountsAndUsers(){
        account1.add(new Account("2365 5677 2343 4344", "1234"));
        account1.add(new Account("3445 8678 8796 0968", "2222"));
        account2.add(new Account("2343 4344 2365 5677", "1234"));
        account2.add(new Account("8796 0968 3445 8678", "2222"));
        users.add(person1);
        users.add(person2);
    }
    @Test
    public void testForSearchCardByNumber()
    {
        Assert.assertEquals(account1.get(0), terminal.searchCardByNumber(users, "2365 5677 2343 4344"));
    }

    @Test
    public void testSearchCardByNumberIsNull()
    {
        Assert.assertEquals(null, terminal.searchCardByNumber(users, "2365 5677 2343 0000"));
    }

    @Test
    public void testIsExistCardWithNumber()
    {
        Assert.assertEquals(true, terminal.isExistCardWithNumber(users, "2365 5677 2343 4344"));
    }

    @Test
    public void testIsNotExistCardWithNumber(){
        Assert.assertEquals(false, terminal.isExistCardWithNumber(users,"2365 5677 2343 0000" ));
    }



}
