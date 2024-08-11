package com.jasp.mini_order_system.repository;

import com.jasp.mini_order_system.entity.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemRepository implements Repository<Item> {

    private static final Map<Integer, Item> DB = new ConcurrentHashMap<>();


    @Override
    public void save(Item entity) {
        DB.put(entity.getId(), entity);
    }

    @Override
    public Item findById(int id) {
        if (!notExists(DB, id)) {
            return DB.get(id);
        }
        return null;
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(DB.values());
    }

    @Override
    public boolean update(Item entity) {
        if (!notExists(DB, entity.getId())) {
            DB.put(entity.getId(), entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (!notExists(DB, id)) {
            DB.remove(id);
            return true;
        }
        return false;
    }
}