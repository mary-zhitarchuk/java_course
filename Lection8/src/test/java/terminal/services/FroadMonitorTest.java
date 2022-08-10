package terminal.services;

import exceptions.NotCcorrectAmountException;
import org.junit.Assert;
import org.junit.Test;

public class FroadMonitorTest{
    private FroadMonitor froadMonitor = new FroadMonitor();

    @Test
    public void testOperationAvailable() throws NotCcorrectAmountException {
        Assert.assertEquals(true, froadMonitor.isOperationAvailable(1000));
    }

    @Test(expected = NotCcorrectAmountException.class)
    public void testNotCcorrectAmountException() throws NotCcorrectAmountException {
        froadMonitor.isOperationAvailable(5896);
    }


}
