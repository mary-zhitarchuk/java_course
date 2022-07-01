package main.java;

public interface Iterator<String>{
    boolean hasNext();
    String next() throws Exception;
    void remove();
}
