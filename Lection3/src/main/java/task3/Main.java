package main.java.task3;

public class Main {
    public static void main(String[] args) {
        String message = "Как у тебя дела?";
        CountLetters countLetters = new CountLetters(message);
        countLetters.getAllLeters();
        countLetters.printAllLetters();
    }
}
