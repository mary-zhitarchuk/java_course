package main.java.task1;

public class UserProfile {
    private String name;
    private String firstName;
    private String passportSeries;
    private String passportNumber;

    public UserProfile() {
    }

    public UserProfile(String name, String firstName, String passportSeries, String passportNumber) {
        this.name = name;
        this.firstName = firstName;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
