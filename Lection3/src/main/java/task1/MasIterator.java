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
    public boolean hasNext(){
        return this.index < mass.length;
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
        int countMoved = mass.length - index - 1;
        if(countMoved > 0) {
            System.arraycopy(mass, index + 1, mass, index, countMoved);
        }
        mass[mass.length - 1] = null;
    }
}
