package main.java.task3;

import main.java.task3.annotations.*;

import java.lang.reflect.Field;


public class Validator {

    private Cat cat;

    public Validator(Cat cat){
        this.cat = cat;
    }

    public void validationCat() throws IllegalAccessException {
        Class<?> clazz = cat.getClass();
        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(Min.class)){
                Min an = field.getAnnotation(Min.class);
                int min = an.value();
                int value = (int) field.get(cat);
                if(value < min){
                    throw new IllegalStateException(field.getName() + "должно быть больше " + min);
                }
            }
            if(field.isAnnotationPresent(Max.class)){
                Max an = field.getAnnotation(Max.class);
                int max = an.value();
                int value = (int) field.get(cat);
                if(value > max){
                    throw new IllegalStateException(field.getName() + " должно быть меньше " + max);
                }
            }
            if(field.isAnnotationPresent(MinLength.class)){
                MinLength an = field.getAnnotation(MinLength.class);
                int min = an.value();
                String value = (String) field.get(cat);
                if(value.length() < min){
                    throw new IllegalStateException(field.getName() + " должно быть больше " + min);
                }
            }
            if(field.isAnnotationPresent(MaxLength.class)){
                MaxLength an = field.getAnnotation(MaxLength.class);
                int max = an.value();
                String value = (String) field.get(cat);
                if(value.length() > max){
                    throw new IllegalStateException(field.getName() + " должно быть меньше " + max);
                }
            }
            if(field.isAnnotationPresent(NotNull.class)){
                if(field.get(cat) == null){
                    throw new IllegalStateException(field.getName() + " не должно быть null");
                }
            }
            if(field.isAnnotationPresent(NotEmpty.class)){

                String value = (String) field.get(cat);
                if(value.isEmpty()){
                    throw new IllegalStateException(field.getName() + " не должно быть пустым");
                }
            }
        }
    }
}
