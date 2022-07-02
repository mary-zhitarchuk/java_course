package main.java.task1;

/**
 * Реализовать Iterator<String> для обычного массива;
 * Продемонстрировать работу получившегося Iterator;
 */
public class Main {

    public static void main(String[] args) {
	    String[] mas = {"one","two","three", "four","five"};
        MasIterator iterator = new MasIterator(mas);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
