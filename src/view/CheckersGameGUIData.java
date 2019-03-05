package view;

import java.util.*;

public class CheckersGameGUIData extends Observable implements Map {

    private Map<Object, Object> mapGUIData;

    public CheckersGameGUIData(Map<Object, Object> mapGUIData){
        super();
        this.mapGUIData = mapGUIData;
    }

    @Override
    public int size() {
        setChanged();
        notifyObservers();
        return mapGUIData.size();
    }

    public Map<Object, Object> getDatas(){
        return this.mapGUIData;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        this.mapGUIData.put(key, value);
        setChanged();
        notifyObservers();

        return null;
    }

    @Override
    public Object remove(Object key) {
        setChanged();
        notifyObservers();
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
