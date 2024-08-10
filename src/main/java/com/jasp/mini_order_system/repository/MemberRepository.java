package com.jasp.mini_order_system.repository;

import com.jasp.mini_order_system.entity.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepository implements Repository<Member> {

    private static final Map<Integer, Member> DB = new ConcurrentHashMap<>();


    @Override
    public void save(Member entity) {
        DB.put(entity.getId(), entity);
    }

    @Override
    public Member findById(int id) {
        if (DB.containsKey(id)) {
            return DB.get(id);
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(DB.values());
    }

    @Override
    public boolean update(Member entity) {
        if (DB.containsKey(entity.getId())) {
            DB.put(entity.getId(), entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (DB.containsKey(id)) {
            DB.remove(id);
            return true;
        }
        return false;
    }
}