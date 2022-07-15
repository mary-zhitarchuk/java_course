package main.java.task3;
/*
    Создать аннотации Min (числа), Max (числа), MaxLength (строки),
    MinLength (строки), NotNull (ссылочные типы), NotEmpty (строки).

    Реализовать класс Validator, который будет проверять POJO-объекты.
*/

import main.java.task3.annotations.Cat;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        List petOwnersNames = new ArrayList<String>();
        petOwnersNames.add("Masha");
        Cat cat = new Cat(11, "Бася", petOwnersNames);
        Validator validator = new Validator();
        validator.validation(cat);
    }
}