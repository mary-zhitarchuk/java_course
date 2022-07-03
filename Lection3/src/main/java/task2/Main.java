package main.java.task2;

public class Main {
    public static void main(String[] args) {
        String equation = " ( 1 + 2 ) * 4 + 3 ";
        Translator translator = new Translator(equation);
        translator.translate();
        System.out.println(translator.getResult());
    }
}
