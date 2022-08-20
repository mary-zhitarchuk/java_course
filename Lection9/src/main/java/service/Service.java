package service;
import annotations.Cachable;

public interface Service {
    @Cachable(filePrefix = "S", zip = true)
    Object doWork(Object... objects);

}
