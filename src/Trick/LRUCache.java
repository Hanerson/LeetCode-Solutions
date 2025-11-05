package Trick;

import java.util.HashMap;
import java.util.PriorityQueue;

class LRUCache {

    PriorityQueue<dot> queue;
    HashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new PriorityQueue<>( (a,b) -> b.life - a.life);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}

class dot{
    int key;
    int life;
    dot(int key) {
        this.key = key;
        this.life = 0;
    }
}