package main.java.transfer;
//Реализовать объект «Перевод» с полями: номер перевода, сумма, валюта, получатель, отправитель, дата перевода
//Реализовать объект «Перевод со счета на счет»
//Реализовать объект «Перевод с карты на карту»
import main.java.person.Recipient;
import main.java.person.Sender;

import java.util.Date;
import java.util.Objects;

public class Transfer {
    public int numberOfTransfer;
    public double summOfTransfer;
    public currencyEnum currency;
    public Recipient recipient;
    public Sender sender;
    public Date dateOfTransfer;
    public boolean fromCardToCard;
    enum currencyEnum {
        ДОЛЛАР,
        РУБ,
        ЕВРО
    }

    public void doTransfer() {
        if (equals(this)) {
            sender.amountOfMoney -= summOfTransfer;
            recipient.amountOfMoney += summOfTransfer;
            System.out.println(this.toString());
        }
        else {
            System.out.println("Перевод совершить нельзя, недостаточно средств");
        }
    }

    @Override
    public boolean equals(Object o) {

        Transfer transfer = (Transfer) o;
        if(transfer.summOfTransfer < sender.amountOfMoney)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(summOfTransfer);
    }

    @Override
    public String toString() {
        if(fromCardToCard) {
            return "ПЕРЕВОД С КАРТЫ НА КАРТУ:" +
                    "Номер перевода: " + numberOfTransfer +
                    ", Дата: " + dateOfTransfer +
                    ", Номер карты получателя: " + recipient.accountNumber +
                    ", Номер карты отправителя: " + sender.accountNumber +
                    ", Валюта: " + currency  +
                    ", Сумма: " + summOfTransfer +
                    ", Получатель: " + recipient +
                    ", Отправитель: "+ sender +
                    '.';
        }
        return "ПЕРЕВОД СО СЧЕТА НА СЧЕТ:" +
                "Номер перевода: " + numberOfTransfer +
                ", Дата: " + dateOfTransfer +
                ", Номер счета получателя: " + recipient.accountNumber +
                ", Номер счета отправителя: " + sender.accountNumber +
                ", Валюта: " + currency  +
                ", Сумма: " + summOfTransfer +
                ", Получатель: " + recipient +
                ", Отправитель: "+ sender +
                '.';
    }

}
