package main.java.task2;
/*
    Реализовать proxy класс который будет выводить в консоль имя метода и время его выполнения
    (проксировать интерфейс Map, использовать любую реализацию);
    Продемонстрировать работу;
*/

import java.lang.reflect.Member;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Throwable {
        Map<Integer, Integer> map = (Map<Integer, Integer>) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[]{Map.class},
                new MyInvocationHandler(new HashMap<Integer,Integer>())
        );
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new HashMap<Integer,Integer>());
        map.put(1,1);
    }
}