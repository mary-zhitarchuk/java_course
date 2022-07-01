package main.java.transfer;
//Реализовать объект «Перевод» с полями: номер перевода, сумма, валюта, получатель, отправитель, дата перевода
//Реализовать объект «Перевод со счета на счет»
//Реализовать объект «Перевод с карты на карту»
import main.java.person.Recipient;
import main.java.person.Sender;

import main.java.enums.Currency;
import java.util.Date;
import java.util.Objects;

public abstract class Transfer {
    protected static int numberOfTransfer;
    protected double summOfTransfer;
    protected Currency currency;
    protected Recipient recipient;
    protected Sender sender;
    protected Date dateOfTransfer;
    protected boolean fromCardToCard;

    public void doTransfer() {
        if (sender.getAmountOfMoney() > summOfTransfer) {
            sender.setAmountOfMoney(sender.getAmountOfMoney() - summOfTransfer);
            recipient.setAmountOfMoney(recipient.getAmountOfMoney() + summOfTransfer);
            System.out.println(getInfoAboutTransfer());
        }
        else {
            System.out.println("Перевод совершить нельзя, недостаточно средств");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return numberOfTransfer == transfer.numberOfTransfer &&
                Double.compare(transfer.summOfTransfer, summOfTransfer) == 0 &&
                fromCardToCard == transfer.fromCardToCard &&
                currency.equals(transfer.currency) &&
                recipient.equals(transfer.recipient) &&
                sender.equals(transfer.sender) &&
                dateOfTransfer.equals(transfer.dateOfTransfer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summOfTransfer);
    }

    public abstract String getInfoAboutTransfer();

    public int getNumberOfTransfer() {
        return numberOfTransfer;
    }

    public void setNumberOfTransfer(int numberOfTransfer) {
        this.numberOfTransfer = numberOfTransfer;
    }

    public double getSummOfTransfer() {
        return summOfTransfer;
    }

    public void setSummOfTransfer(double summOfTransfer) {
        this.summOfTransfer = summOfTransfer;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Date getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(Date dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }

    public boolean isFromCardToCard() {
        return fromCardToCard;
    }

    public void setFromCardToCard(boolean fromCardToCard) {
        this.fromCardToCard = fromCardToCard;
    }
}
