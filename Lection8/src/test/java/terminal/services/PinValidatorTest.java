package terminal.services;

import account.Account;
import com.beust.jcommander.Parameter;
import exceptions.AccountIsLockedException;
import exceptions.NotValidPinException;
import exceptions.PinLengthException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PinValidatorTest {
    private PinValidator pinValidator = new PinValidator();
    private Account account = new Account("2365 5677 2343 4344", "1234");

    @Test
    public void testsValidLength(){
        Assert.assertEquals(true, pinValidator.isValidLength("1234"));
    }

    @Test(expected = PinLengthException.class)
    public void testPinLengthException(){
        pinValidator.isValidLength("12345");
    }

    @Test
    public void testPinIsValid() throws IOException {
        Assert.assertEquals(true, pinValidator.isPinValid(account));
    }

    @Test
    public void testPinIsNotValid() throws IOException {
        Assert.assertEquals(false, pinValidator.isPinValid(account));
    }

    @Test
    public void testPinValidatorDataIsNull() throws IOException {
        pinValidator.setData(null);
        Assert.assertEquals(false, pinValidator.isPinValid(account));
    }

    @Test
    public void testPinIsRight(){
        Assert.assertEquals(true, pinValidator.pinIsRight(account, "1234", 2));
    }

    @Test
    public void testPinIsNotRight(){
        Assert.assertEquals(false, pinValidator.pinIsRight(account, "1235", 2));
    }

    @Test
    public void testPinBlocked(){
        Assert.assertEquals(false, pinValidator.pinIsRight(account, "1235", 3));
    }



}
