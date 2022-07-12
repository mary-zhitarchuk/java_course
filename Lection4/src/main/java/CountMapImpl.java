package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class CountMapImpl<V> implements CountMap<V> {
    private LinkedList<V> container = new LinkedList<>();
    private LinkedList<MapElement<V>> resultMap = new LinkedList<>();
    private Map<V, Integer> map = new HashMap<>();
    @Override
    public void add(V o) {
        MapElement<V> element = new MapElement<>(o);
        if (!container.contains(o)) {
            container.add(o);
            resultMap.add(element);
        } else {
            for (MapElement<V> elem : resultMap) {
                if (elem.equals(element)) {
                    elem.setKey(elem.getKey() + 1);
                    break;
                }
            }
        }
    }

    @Override
    public int getCount(V o) {
        int countElems = 0;
        for (MapElement<V> element : resultMap)
        {
            if(element.getValue() == o){
                countElems = element.getKey();
            }
        }
        return countElems;
    }

    @Override
    public int remove(V o) {
        int countElems = getCount(o);
        for (MapElement<V> element : resultMap)
        {
            if(element.getValue() == o){
                resultMap.remove(element);
                container.remove(element.getValue());
            }
        }
        return countElems;
    }

    @Override
    public int size() {
        int size = resultMap.size();
        return size;
    }

    @Override
    public void addAll(CountMap<V> source) {
        Map sourceMap = source.toMap();
        for(V el : (Set<V>) sourceMap.keySet()) {
            if(!container.contains(el)) {
                resultMap.add(new MapElement<V>(el, (Integer) sourceMap.get(el)));
                container.add(el);
            }else{
                for (MapElement<V> elem : resultMap) {
                    if (elem.getValue() == el) {
                        elem.setKey(elem.getKey() + (Integer) sourceMap.get(el));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Map toMap() {
       for(MapElement<V> elem : resultMap)
       {
           map.put(elem.getValue(), elem.getKey());
       }
        return map;
    }

    @Override
    public void toMap(Map destination) {
        for(MapElement<V> elem : resultMap)
        {
            destination.put(elem.getValue(), elem.getKey());
        }
    }
}
