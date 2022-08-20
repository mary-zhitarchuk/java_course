package service;

import serialization.SerializeTime;

public class TimeServiceImpl implements Service{
    @Override
    public Object doWork(Object... objects) {
        return new SerializeTime();
    }
}
