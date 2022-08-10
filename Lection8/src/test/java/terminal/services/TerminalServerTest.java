package terminal.services;

import account.Account;
import exceptions.NotEnoughMoneyOnAccountException;
import org.junit.Assert;
import org.junit.Test;

public class TerminalServerTest {
    private TerminalServer terminalServer = new TerminalServer();
    private Account account = new Account("2365 5677 2343 4344", "1234");

    @Test
    public void testEnoughMoney(){
        Assert.assertEquals(true, terminalServer.isEnoughMoney(account, 250));
    }

    @Test(expected = NotEnoughMoneyOnAccountException.class)
    public void testNotEnoughMoneyOnAccountException(){
        terminalServer.isEnoughMoney(account, 25000);
    }
}
