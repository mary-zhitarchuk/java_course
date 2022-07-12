package main.java.task1;

/*
    Реализовать класс, метод которого будет копировать значения полей класса A и класса B
    (названия классов должны быть не A и B) в новый класс C, если их имена совпадают;
    Продемонстрировать работу.
*/

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", "qwerty");
        Passport passport = new Passport("2323", "2424242", new Date());
        UserProfile userProfile = ObjectCreater.copyParams(person, passport, UserProfile.class);
        System.out.println(userProfile);
    }
}


/*
public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    Person person = new Person("Ivan", "Ivanov", "qwerty");
    Passport passport = new Passport("2323", "2424242", new Date());
    UserProfile userProfile = ObjectCreater.mergeObjects(person, passport, UserProfile.class);
    System.out.println(userProfile)}

Вывод:
UserProfile{firstName='Ivan', lastName='Ivanov', series='2323', number='2424242'}

 */