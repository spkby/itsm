package com.itechart.commuterange.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CitiesCache<K, V> implements Cache<K, V> {
    private final int MAX_CAPACITY;
    private Map<K, CacheEntry> cacheMap = new HashMap<>();
    private Map<K, Integer> countsOfGet = new HashMap<>();
    private TreeMap<Integer, LFULinkedList> frequencies = new TreeMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public CitiesCache(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    /**
     * Gets value from LFU cache if cache contains one
     *
     * @param key represents key of map
     * @return value from map, if map does not contain @param key - returns null
     */
    public V get(K key) {
        readLock.lock();
        try {
            if (cacheMap.containsKey(key)) {
                //gets CacheEntry from cacheMap
                CacheEntry cacheEntry = cacheMap.get(key);
                //gets frequency of using CacheEntry by it`s key from countsofGet map
                int frequency = countsOfGet.get(key);
            /*
            transfers CacheEntry from one linked list to another,
            depending on frequency. If linked list with new frequency is absent - creates new one
            and puts CacheEntry in it
             */
                frequencies.get(frequency).remove(cacheEntry);
                if (frequencies.get(frequency).size == 0) {
                    frequencies.remove(frequency);
                }
                frequencies.computeIfAbsent(frequency + 1, k -> new LFULinkedList()).add(cacheEntry);
                //inserting into map countsOfGet and increasing frequency
                countsOfGet.put(key, frequency + 1);
                return cacheMap.get(key).getValue();
            }
        } finally {
            readLock.unlock();
        }
        return null;
    }

    /**
     * puts @value to CacheMap, increases frequency of using if one`s exists in map
     * @param key to be put in map
     * @param value to be associated with key
     */
    public V put(K key, V value) {
        writeLock.lock();
        if (!cacheMap.containsKey(key)) {
            CacheEntry cacheEntry = new CacheEntry(key, value);

            if (cacheMap.size() == MAX_CAPACITY) {
                /*
                gets first linked list from frequencies map because first linked list
                is associated with minimum frequency in this map
                */
                int lowestCount = frequencies.firstKey();
                /*
                gets CacheEntry that should me removed before new CacheEntry
                can be inserted
                 */
                CacheEntry entryToDelete = frequencies.get(lowestCount).head();
                frequencies.get(lowestCount).remove(entryToDelete);

                K keyToDelete = entryToDelete.getKey();
                if (frequencies.get(lowestCount).size == 0) {
                    frequencies.remove(lowestCount);
                }
                cacheMap.remove(keyToDelete);
                countsOfGet.remove(keyToDelete);
            }

            cacheMap.put(key, cacheEntry);
            countsOfGet.put(key, 1);
            frequencies.computeIfAbsent(1, k -> new LFULinkedList()).add(cacheEntry);
            writeLock.unlock();
        } else {
            V val = get(key);
            CacheEntry entry = cacheMap.get(key);
            entry.setValue(value);
            cacheMap.put(key, entry);
        }
        return value;
    }

    /**
     * object of this class represents the value of CacheMap
     */
    class CacheEntry {
        private K key;
        private V value;
        private CacheEntry next;
        private CacheEntry previous;

        public CacheEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * object of this class represents the linked list
     * associated with frequency of using object in this linked list
     */
    class LFULinkedList {
        private int size;
        private CacheEntry head;
        private CacheEntry tail;

        public void add(CacheEntry cacheEntry) {
            if (head == null) {
                head = cacheEntry;
            } else {
                tail.next = cacheEntry;
                cacheEntry.previous = tail;
            }
            tail = cacheEntry;
            size++;
        }

        public void remove(CacheEntry cacheEntry) {
            if (cacheEntry.next == null) {
                tail = cacheEntry.previous;
            } else {
                cacheEntry.next.previous = cacheEntry.previous;
            }

            if (head.key == cacheEntry.key) {
                head = cacheEntry.next;
            } else {
                cacheEntry.previous.next = cacheEntry.next;
            }

            size--;
        }

        public CacheEntry head() {
            return head;
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<K, CacheEntry> entry : cacheMap.entrySet()) {
                sb.append(entry.getKey());
                sb.append(" : ");
                sb.append(entry.getValue());
                sb.append(",");
            }
            return "LFULinkedList{" + sb.toString() + "}";
        }
    }
}
