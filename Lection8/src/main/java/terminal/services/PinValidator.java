package terminal.services;

import account.Account;
import exceptions.AccountIsLockedException;
import exceptions.NotValidPinException;
import exceptions.PinLengthException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class PinValidator {
    private int numberOfInvalidPins = 0;
    private int timeBlock = 5;
    private Object data = null;
    private Timer timer = new Timer();

    private int delayTimer = 5000;

    public boolean isValidLength(String pin) {
        if (pin.matches("\\d{4}")){
            return true;
        } else throw new PinLengthException();
    }

    public boolean isPinValid(Account account) throws AccountIsLockedException {
        /*System.out.println("Введите пинкод: ");
        Scanner scanner = new Scanner(System.in);
        String pin = scanner.next();*/
        try {

            FileReader file = new FileReader("src/main/java/pin.txt");
            int c;
            String pin = "";
            while ((c = file.read()) != -1) {
                pin += (char) c;
            }

            if (isValidLength(pin)) {
                if (!pinIsRight(account, pin, numberOfInvalidPins)) {
                    numberOfInvalidPins++;
                } else return true;
            }
            if (this.data != null) {
                timerLockCard(account);
                account.setBlocked(true);
                return false;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean pinIsRight(Account account, String pin, int numberOfInvalidPins) {
        try {
            if (numberOfInvalidPins >= 3) {
                this.data = new Object();
                throw new AccountIsLockedException(timeBlock);
            } else if (account.getPin().equals(pin))
                return true;
            else throw new NotValidPinException(numberOfInvalidPins);

        } catch(Exception e) {
            System.err.println(e.getMessage());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public void timerLockCard(Account account) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeBlock--;
                account.setTimeToUnlock(timeBlock);
                if (timeBlock <= 0) {
                    account.setBlocked(false);
                    timer.cancel();
                }
            }
        }, 0, delayTimer / 5);
    }

    public int getNumberOfInvalidPins() {
        return numberOfInvalidPins;
    }

    public void setNumberOfInvalidPins(int numberOfInvalidPins) {
        this.numberOfInvalidPins = numberOfInvalidPins;
    }

    public int getTimeBlock() {
        return timeBlock;
    }

    public void setTimeBlock(int timeBlock) {
        this.timeBlock = timeBlock;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getDelayTimer() {
        return delayTimer;
    }

    public void setDelayTimer(int delayTimer) {
        this.delayTimer = delayTimer;
    }
}
