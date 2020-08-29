package oops.assignments.bookmyshow.repository;

import java.util.*;

public class Repository<T, K> {

    Map<K, T> map;

    protected Repository() {
        this.map = new HashMap<>();
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
