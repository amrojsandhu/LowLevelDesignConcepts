package oops.assignments.bookmyshow.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Repository<T, K> {

    Map<K, T> map;

    protected Repository() {
        this.map = new ConcurrentHashMap<>();
    }

    public void save(T obj, K id) {
        this.map.put(id, obj);
    }

    public T getById(K id) {
        return this.map.get(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(map.values());
    }
}
