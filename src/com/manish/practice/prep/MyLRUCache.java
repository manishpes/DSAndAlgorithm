package com.manish.practice.prep;


import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node pre = null;
    Node next = null;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> lruMap;
    int CAPACITY;
    int count;
    Node head;
    Node tail;

    LRUCache(int size) {
        this.CAPACITY = size;
        lruMap = new HashMap<>();
        head = null;
        tail = head;
//        head.pre = null;
//        head.next = tail;
//        tail.pre = head;
//        tail.next = null;
        count = 0;
    }

    private void addToFront(Node node) {
        node.next = head;
        head.pre = node;
        node.pre = head.pre;
        head = node;
    }

    private void removeNode(Node node) {

        tail.pre.next = null;
        tail = tail.pre;
    }

    /*
       1. if map doesn't contain return -1
       2. if map contains get the value delete node and add to the front.
       3.

     */
    public int get(int key) {

        if (head == null || !lruMap.containsKey(key))
            return -1;

        Node node = lruMap.get(key);
        removeNode(node);
        addToFront(node);
        return node.value;
    }

    public void set(int key, int value) {

        if (head == null || count == 0) {

            head = new Node(key, value);
            head.next = tail;
            head.pre = null;
            tail = head;
            lruMap.put(key, head);
            count++;
        }

        if (lruMap.containsKey(key)) {

            Node node = lruMap.get(key);
            if (count != 1) {
                removeNode(tail);
                addToFront(node);
            }

        } else {
            Node node = new Node(key, value);
            lruMap.put(key, node);
            if (count < CAPACITY) {
                count++;
                addToFront(node);
            } else {
                lruMap.remove(tail.key);
                removeNode(tail);
                addToFront(node);
            }

        }

    }
    public void print()
    {
        Node temp = head;
        System.out.println("\nDList ");
        while(temp != null)
        {
            System.out.print(temp.key+", ");
            temp = temp.next;
        }
    }

}

public class MyLRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);  // 1
        cache.print();
        cache.set(2, 20);  // 2-1
        cache.print();
        System.out.println("\nCache value "+cache.get(1)); //1-2
        cache.print();
        System.out.println("\nCache value "+ cache.get(2)); // 2-1
        cache.print();
        cache.set(4, 40);  //4-2
        cache.print();
        System.out.println("Cache value "+ cache.get(4));//4-2
        System.out.println("Cache value "+ cache.get(2));//2-4
        System.out.println("Cache value "+ cache.get(1));//-1


    }

}
