package main.java.task1;

import java.util.Date;

public class Passport {
    private String passportSeries;
    private String passportNumber;
    private Date dateOfRegistration;

    public Passport(String passportSeries, String passportNumber, Date dateOfRegistration) {
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.dateOfRegistration = dateOfRegistration;
    }
}
