package org.example.util;

import java.util.HashMap;
import java.util.Map;

public class LongCache {
    Map<Long,Long> cache = new HashMap<>();

    Long get(Long key) {
        return cache.get(key);
    }

    void put(Long key, Long value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LongCache c = new LongCache();
        c.put(2L, 4L);
        System.out.println(c.get(2L));
        System.out.println(c.get(3L));

    }
}
