package com.manish.practice.ds;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class MyHashMap {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap(2);
        hashMap.put(1, 2);
        hashMap.put(3, 4);
        hashMap.put(2, 3);

        System.out.println(hashMap.toString());
        System.out.println("hashMap.get(2) :: " + hashMap.get(2));

        System.out.println(hashMap.delete(2));
        System.out.println(hashMap.toString());

        System.out.println(hashMap.delete(1));
        System.out.println(hashMap.toString());


    }


}

class Entry <K, V>{
    K key;
    V value;
    Entry next;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}

class HashMap <K, V>{

    int SIZE = 16;
    Entry <K, V>myHashMapEntry[];

    public HashMap() {
        myHashMapEntry = new Entry[SIZE];
    }

    public HashMap(int size) {
        this.SIZE = size;
        myHashMapEntry = new Entry[size];
    }


    public void put(K key, V value) {

        Entry <K, V> newEntry = new Entry(key, value);
        int hash = key.hashCode() % SIZE;
        Entry entry = myHashMapEntry[hash];
        if (entry == null) {
            myHashMapEntry[hash] = newEntry;
        } else {
            while (entry.next != null) {
                if (entry.key.equals(key)) { //collision
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            entry.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = myHashMapEntry[hash];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        return entry != null ? entry.value : null;
    }

    public boolean delete(K key) {

        int hash = key.hashCode() % SIZE;
        Entry entry = myHashMapEntry[hash];

        Entry curr = entry, prev = null;
        while (curr != null && !curr.key.equals(key)) // find the node to delete
        {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) // Key not found.
            return false;

        if (prev == null) { // delete element is first element
            entry = entry.next;
        } else {
            prev.next = curr.next; // delete and point to next element
        }
        myHashMapEntry[hash] = entry;
        return true;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "myHashMapEntry=" + Arrays.toString(myHashMapEntry) +
                '}';
    }

}

