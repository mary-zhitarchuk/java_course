import com.tasks.Task;
import com.threads.FixedThreadPool;
import com.threads.ScalableThreadPool;
import com.threads.ThreadPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool fixedThreadPool = new FixedThreadPool(5);
        fixedThreadPool.start();

        for (int i = 1; i <= 5; i++) {
            Task task = new Task(i);
            fixedThreadPool.execute(task);
        }

        Thread.sleep(20000);
        fixedThreadPool.stop();

        System.out.println("----------------------------------\n\n");

        ThreadPool scalableThreadPool = new ScalableThreadPool(2, 5);
        scalableThreadPool.start();
        for (int i = 1; i <= 10; i++) {
            Task task = new Task(i);
            scalableThreadPool.execute(task);
        }
        Thread.sleep(20000);
        scalableThreadPool.stop();
    }
}
