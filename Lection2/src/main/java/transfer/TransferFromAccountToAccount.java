package main.java.transfer;

import main.java.person.Recipient;
import main.java.person.Sender;

import java.util.Date;

public class TransferFromAccountToAccount extends Transfer {
    public TransferFromAccountToAccount(Recipient recipient, Sender sender, double summOfTransfer){
        this.fromCardToCard = false;
        this.recipient = recipient;
        this.sender = sender;
        this.summOfTransfer = summOfTransfer;
        this.dateOfTransfer = new Date();
        this.currency = currencyEnum.РУБ;
    }

}
