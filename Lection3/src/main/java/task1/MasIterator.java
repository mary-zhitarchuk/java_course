package main.java.task1;

import main.java.task1.Iterator;

public class MasIterator implements Iterator {
    private String[] mass;
    private int index;

    public MasIterator(String[] mass) {
        this.mass = mass;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.index < mass.length)
            return true;
        else
            return false;
    }

    @Override
    public String next(){
        try {
            if (hasNext()) {
                return mass[index++];
            }
        }catch (Exception e){
            e.getMessage();
        }
        return "No elements next";
    }

    @Override
    public void remove() {
        mass[index] = null;
    }
}
