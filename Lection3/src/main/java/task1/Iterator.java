package main.java.task1;

public interface Iterator<T>{
    boolean hasNext();
    T next() throws Exception;
    void remove();
}
