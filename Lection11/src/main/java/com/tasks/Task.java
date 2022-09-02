package com.tasks;

import java.util.*;

public class Task implements Runnable {
    private final int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        System.out.println("Task number " + taskNumber + " is running by " + Thread.currentThread().getName() + " thread");
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++){
            array.add(new Random().nextInt(100));
        }
        Collections.sort(array);
        System.out.println("Task number " + taskNumber + " is finished by " + Thread.currentThread().getName() + " thread");
    }
}
