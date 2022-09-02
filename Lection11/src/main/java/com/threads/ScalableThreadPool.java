package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableThreadPool implements ThreadPool {
    private final int minCountThreads;
    private final int maxCountThreads;
    private List<Worker> threads;
    private Queue queue;

    private boolean isRunning = true;

    public ScalableThreadPool(int minCountThreads, int maxCountThreads) {
        this.minCountThreads = minCountThreads;
        this.maxCountThreads = maxCountThreads;
        this.threads = new ArrayList<>();
        this.queue = new LinkedBlockingQueue();
    }


    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);

            for (Worker thread : threads) {
                if (thread.getState() == Thread.State.WAITING) {
                    queue.notify();
                    return;
                }
            }

            if (threads.size() < maxCountThreads) {
                threads.add(new Worker());
                threads.get(threads.size() - 1).start();
            }

            queue.notify();
        }
    }

    @Override
    public void stop() {
        isRunning = false;
    }


    private void removeWorker(Worker worker) {
        synchronized (queue) {
            if (queue.size() == 0 && threads.size() > minCountThreads) {
                worker.dismiss();
                threads.remove(worker);
            }
        }
    }

    private class Worker extends Thread {
        private volatile boolean canWork = true;

        public void dismiss() {
            canWork = false;
        }

        public void run() {
            Runnable task;

            while (isRunning) {
                while (canWork) {
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

                    removeWorker(this);
                }
            }
        }
    }
}
