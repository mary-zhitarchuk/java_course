package cache;

import serialization.SrializeList;
import service.Service;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    private Service service;
    private CacheProxy cacheProxy;

    public LogHandler(CacheProxy cacheProxy, Service service) {
        this.cacheProxy = cacheProxy;
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("doWork")){
            Object result = null;
            if(cacheProxy.isNeedCashed()){
                System.out.println("Обнаружена аннотация Cacheable. Ищем сохраненный результат...");

                Object[] arguments = (Object[]) args[0];

                StringBuilder filePath = new StringBuilder(cacheProxy.getPathToFile() + cacheProxy.getFileName());
                for (Object arg : arguments)
                    filePath.append("_").append(arg);
                filePath.append(".bin");

                File newFile = new File(filePath.toString());
                if (newFile.exists()) {
                    System.out.println("Возвращаем кэшированное значение");
                    Object cachedObject = SrializeList.deserialize(filePath.toString());
                    System.out.println(cachedObject);
                } else {
                    result = method.invoke(service, args);

                    System.out.println("Кэшируем результат и возвращаем его");
                    cacheProxy.writeToFile(result, filePath.toString());
                    System.out.println(result);
                }
            } else {
                System.out.println("Работа сервиса без кеширования данных");
                result = method.invoke(service, args);
                System.out.println(result);
            }
            return result;
        }
        return method.invoke(service, args);
    }
}
