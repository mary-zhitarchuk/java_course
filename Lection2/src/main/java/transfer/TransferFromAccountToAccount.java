package main.java.transfer;

import main.java.person.Recipient;
import main.java.person.Sender;

import main.java.enums.Currency;
import java.util.Date;

public class TransferFromAccountToAccount extends Transfer {
    public TransferFromAccountToAccount(Recipient recipient, Sender sender, double summOfTransfer, Currency currency) {
        this.setNumberOfTransfer(getNumberOfTransfer()+1);
        this.recipient = recipient;
        this.sender = sender;
        this.summOfTransfer = summOfTransfer;
        this.dateOfTransfer = new Date();
        this.currency = currency;
    }


    @Override
    public String getInfoAboutTransfer() {
        return "ПЕРЕВОД СО СЧЕТА НА СЧЕТ:" +
                "Номер перевода: " + numberOfTransfer +
                ", Дата: " + dateOfTransfer +
                ", Номер счета получателя: " + recipient.getAccountNumber() +
                ", Номер счета отправителя: " + sender.getAccountNumber() +
                ", Валюта: " + currency +
                ", Сумма: " + summOfTransfer +
                ", Получатель: " + recipient.getFullNameLowerCase() +
                ", Отправитель: " + sender.getFullNameUpperCase() +
                '.';
    }
}
