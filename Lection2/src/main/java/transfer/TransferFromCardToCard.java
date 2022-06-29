package main.java.transfer;

import main.java.person.Recipient;
import main.java.person.Sender;

import main.java.enums.Currency;
import java.util.Date;

public class TransferFromCardToCard extends Transfer {
    public TransferFromCardToCard(Recipient recipient, Sender sender, double summOfTransfer, Currency currency){
        this.setNumberOfTransfer(getNumberOfTransfer()+1);
        this.fromCardToCard = true;
        this.recipient = recipient;
        this.sender = sender;
        this.summOfTransfer = summOfTransfer;
        this.dateOfTransfer = new Date();
        this.currency = currency;
    }

    @Override
    public String getInfoAboutTransfer() {
        return "ПЕРЕВОД С КАРТЫ НА КАРТУ:" +
                "Номер перевода: " + numberOfTransfer +
                ", Дата: " + dateOfTransfer +
                ", Номер карты получателя: " + recipient.getCardNumber() +
                ", Номер карты отправителя: " + sender.getCardNumber() +
                ", Валюта: " + currency  +
                ", Сумма: " + summOfTransfer +
                ", Получатель: " + recipient.getFullNameUpperCase() +
                ", Отправитель: "+ sender.getFullNameUpperCase() +
                '.';
    }
}
