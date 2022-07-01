package main.java;

public class MasIterator implements Iterator{
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
    public String next() throws Exception {
        index++;
        if(hasNext()) {
            return mass[index];
        }else throw new Exception();
    }

    @Override
    public void remove() {
        mass[index] = null;
    }
}
