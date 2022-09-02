package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int threadsCount;
    private Queue queue;
    private List<Worker> threads;
    private boolean isRunning = true;

    public FixedThreadPool(int threadsCount) {
        this.threads = new ArrayList<>();
        this.queue = new LinkedBlockingQueue();
        this.threadsCount = threadsCount;
    }

    @Override
    public void start() {
        for(int i = 0; i < threadsCount; i++){
            threads.add(new Worker());
            threads.get(i).start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }
    @Override
    public void stop(){
        isRunning = false;
    }

    public int getThreadsCount() {
        return threadsCount;
    }

    private class Worker extends Thread {
        public void run() {
            Runnable task;

            while (isRunning) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.err.println("Ошибка во время ожидания потока: " + e.getMessage());
                        }
                    }
                    task = (Runnable) queue.poll();
                }

                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.err.println("Пул потоков прерван: " + e.getMessage());
                }
            }
        }
    }

}