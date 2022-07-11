package main.java;

import java.util.Objects;

public class MapElement<V> {
    private V value;
    private int key;

    public MapElement(V value) {
        this.value = value;
        this.key++;
    }

    public MapElement(V value, int key) {
        this.value = value;
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapElement<?> that = (MapElement<?>) o;
        return key == that.key && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, key);
    }
}
