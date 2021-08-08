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
    Node head;
    Node tail;
    int CAPACITY;
    int count;

    LRUCache(int size) {
        lruMap = new HashMap();
        this.CAPACITY = size;
        this.count = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }

    void set(int key, int value) {

        if (lruMap.containsKey(key)) {
            Node curNode = lruMap.get(key);
            curNode.value = value;
            removeNode(curNode);
            addToFront(curNode);
        } else {
            Node node = new Node(key, value);
            if (count < CAPACITY) {
                count++;
                addToFront(node);
                lruMap.put(key, node);

            } else {
                lruMap.remove(tail.pre.key);
                removeNode(tail.pre);
                addToFront(node);
                lruMap.put(key, node);
            }

        }
    }

    void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }
    void addToFront(Node node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;


        head.next = node;
    }

    int get(int key) {

        if(lruMap.containsKey(key)){
            Node node = lruMap.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }


    public void print() {
        Node temp = head.next;
        System.out.println("\nDList ");
        while (temp != null && temp!= tail) {
            System.out.print(temp.key + ", ");
            temp = temp.next;
        }
    }

}

public class MyLRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);  // 1
        cache.set(1, 20);  // 1
        cache.print();
        cache.set(2, 20);  // 2-1
        cache.print();
//        System.out.println("\nCache value "+cache.get(1)); //1-2
        cache.print();
//        System.out.println("\nCache value "+ cache.get(2)); // 2-1
//        cache.print();
//        cache.set(4, 40);  //4-2
//        cache.print();
//        System.out.println("Cache value "+ cache.get(4));//4-2
//        System.out.println("Cache value "+ cache.get(2));//2-4
        System.out.println("\nCache value " + cache.get(1));//-1


    }

}
