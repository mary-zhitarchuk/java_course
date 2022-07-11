package main.java;

/**
 * создать интерфейс CountMap
 * параметризовать его и реализовать
 * в реализации нельзя использовать Map
 */

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        System.out.println("Количество элементов со значением 5: " + map.getCount(5));
        System.out.println("Количество элементов со значением 6: " + map.getCount(6));
        System.out.println("Количество элементов со значением 10: " + map.getCount(10));
        System.out.println("Количество элементов со значением 1: " + map.getCount(1));

        System.out.println("Удаление элемента со значением 5. \n Количество элементов со значением 5 до удаления: " + map.remove(5));
        System.out.println("Количество элементов со значением 5 после удаления: " + map.getCount(5));

        System.out.println("Количество уникальных элементов в CountMap: " + map.size());
        CountMap<Integer> map2 = new CountMapImpl<>();
        map2.add(11);
        map2.add(11);
        map2.add(5);
        map2.add(4);
        map2.add(5);
        map2.add(10);
        map.addAll(map2);

        System.out.println("Количество элементов со значением 5: " + map.getCount(5));
        System.out.println("Количество элементов со значением 6: " + map.getCount(6));
        System.out.println("Количество элементов со значением 10: " + map.getCount(10));
        System.out.println("Количество элементов со значением 11: " + map.getCount(11));
        System.out.println("Количество элементов со значением 4: " + map.getCount(4));
    }
}
