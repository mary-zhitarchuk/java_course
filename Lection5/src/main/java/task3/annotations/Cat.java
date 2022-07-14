package main.java.task3.annotations;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    @Min
    @Max(25)
    private int age;

    @MinLength
    @MaxLength(30)
    @NotEmpty
    private String name;

    @NotNull
    private List<String> petOwnersNames;

    public Cat(int age, String name, List<String> petOwnersNames) {
        this.age = age;
        this.name = name;
        this.petOwnersNames = petOwnersNames;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPetOwnersNames() {
        return petOwnersNames;
    }

    public void setPetOwnersNames(List<String> petOwnersNames) {
        this.petOwnersNames = petOwnersNames;
    }
}
