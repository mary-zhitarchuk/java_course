package main.java.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MyInvocationHandler implements InvocationHandler {

    private final Object delegate;
    public  MyInvocationHandler(Object delegate){
        this.delegate = delegate;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(delegate, args);
        System.out.println("Метод: " + method.getName());
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения " + (endTime - startTime) + " milliseconds");
        return result;
    }
}
