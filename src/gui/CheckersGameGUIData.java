package gui;

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
        Object result = this.mapGUIData.get(key);
        setChanged();
        notifyObservers();

        return result;
    }

    @Override
    public Object put(Object key, Object value) {
        Object result = this.mapGUIData.put(key, value);
        setChanged();
        notifyObservers();

        return result;
    }

    @Override
    public Object remove(Object key) {
        Object result = this.mapGUIData.remove(key);
        setChanged();
        notifyObservers();

        return result;
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
