import cache.CacheProxy;
import service.Service;
import service.ListServiceImpl;
import service.TimeServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("******* START TASK 1 *******");

        CacheProxy cacheProxy = new CacheProxy();
        Service listService = cacheProxy.cache(new ListServiceImpl());
        doTest1(listService);
        Service timeService = cacheProxy.cache(new TimeServiceImpl());
        doTest2(timeService);
    }

    private static void doTest1(Service listService) {
        listService.doWork(10, 100);
        listService.doWork(5, 20);
        listService.doWork(15, 10);
        listService.doWork(10, 100);
    }

    private static void doTest2(Service timeService){
        timeService.doWork("Work1");
        timeService.doWork("Work2");
        timeService.doWork("Work3");
        timeService.doWork("Work1");
    }
}
