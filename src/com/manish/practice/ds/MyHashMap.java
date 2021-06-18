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

class Entry {
    int key;
    int value;
    Entry next;

    Entry(int key, int value) {
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

class HashMap {

    int SIZE = 16;
    Entry myHashMapEntry[];

    public HashMap() {
    }

    public HashMap(int size) {
        this.SIZE = size;
        myHashMapEntry = new Entry[size];
    }


    public void put(Integer key, Integer value) {

        Entry newEntry = new Entry(key, value);
        int hash = key.hashCode() % SIZE;
        Entry entry = myHashMapEntry[hash];
        if (entry == null) {
            myHashMapEntry[hash] = newEntry;
        } else {
            while (entry.next != null) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            entry.next = newEntry;
        }
    }

    public Integer get(Integer key) {
        int hash = key.hashCode() % SIZE;
        Entry entry = myHashMapEntry[hash];
        while (entry != null && entry.key != key) {
            entry = entry.next;
        }
        return entry != null ? entry.value : null;
    }

    public boolean delete(Integer key) {

        int hash = key.hashCode() % SIZE;
        Entry entry = myHashMapEntry[hash];

        Entry curr = entry, prev = null;
        while (curr != null && curr.key != key) // find the node to delete
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

