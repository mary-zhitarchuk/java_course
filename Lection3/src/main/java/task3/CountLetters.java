package main.java.task3;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 *  Реализовать класс, метод которого будет считать количество каждого символа в строке и выводить в порядке убывания
 *  Например для строки: «Как у тебя дела?» метод должен распечатать:
 * К: 2
 * Е: 2
 * А: 2
 * У: 1
 * Т: 1
 * Б: 1
 *
 **/
public class CountLetters {
    private String message;
    private Map<Character, Integer> letters;

    public CountLetters(String message) {
        this.message = message;
        this.letters = new HashMap<Character, Integer>();
    }

    public void getAllLeters()
    {
        char[] masLetters = getMessage().toUpperCase(Locale.ROOT).replaceAll(" ", "").toCharArray();
        for(char letter : masLetters){
            if(!letters.containsKey(letter)){
                letters.put(letter, 1);
            }
            else {
                letters.put(letter, letters.get(letter) + 1);
            }
        }
    }

    public void printAllLetters(){
        letters.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    public Map<Character, Integer> getLetters() {
        return letters;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLetters(Map<Character, Integer> letters) {
        this.letters = letters;
    }
}
