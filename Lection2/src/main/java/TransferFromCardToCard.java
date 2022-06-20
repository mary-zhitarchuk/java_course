package main.java;

import main.java.person.Recipient;
import main.java.person.Sender;

import java.util.Date;

public class TransferFromCardToCard extends Transfer {
    public TransferFromCardToCard(Recipient recipient, Sender sender, double summOfTransfer, String currency){
        this.fromCardToCard = true;
        this.recipient = recipient;
        this.sender = sender;
        this.summOfTransfer = summOfTransfer;
        this.dateOfTransfer = new Date();
        this.currency = currency;
    }
}
