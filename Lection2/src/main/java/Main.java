package main.java;

import main.java.person.Recipient;
import main.java.person.Sender;

public class Main {
    public static void main(String[] args) {
        Sender sender1 = new Sender();
        Recipient recipient1 = new Recipient();
        TransferFromCardToCard transfer1 = new TransferFromCardToCard(recipient1, sender1, 200, "РУБ");
        transfer1.doTransfer();

        TransferFromAccountToAccount transfer2 = new TransferFromAccountToAccount(recipient1, sender1, 200, "РУБ");
        transfer2.doTransfer();
    }
}
