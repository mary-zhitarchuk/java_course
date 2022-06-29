package main.java;

import main.java.person.Recipient;
import main.java.person.Sender;
import main.java.transfer.TransferFromAccountToAccount;
import main.java.transfer.TransferFromCardToCard;

import main.java.enums.Currency;

public class Main {
    public static void main(String[] args) {
        Sender sender1 = new Sender();
        Recipient recipient1 = new Recipient();

        TransferFromCardToCard transfer1 = new TransferFromCardToCard(recipient1, sender1, 400, Currency.DOLLAR );
        transfer1.doTransfer();

        TransferFromAccountToAccount transfer2 = new TransferFromAccountToAccount(recipient1, sender1, 200, Currency.RUB);
        transfer2.doTransfer();

        TransferFromAccountToAccount transfer3 = new TransferFromAccountToAccount(recipient1, sender1, 500, Currency.EURO);
        transfer3.doTransfer();
    }
}
