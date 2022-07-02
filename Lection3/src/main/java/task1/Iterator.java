package main.java.task1;

public interface Iterator<String>{
    boolean hasNext();
    String next() throws Exception;
    void remove();
}
