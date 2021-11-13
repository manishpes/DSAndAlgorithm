package com.manish.practice.prep;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUJava {

    Deque<Integer> dqueue;
    HashSet<Integer> hashSet;
    int CAPACITY = 16;
    LRUJava(int size){
        this.CAPACITY = size;
        dqueue = new LinkedList<>();
        hashSet = new HashSet<>();

    }
    public void refer (int page){

        if(!hashSet.contains(page))
        {
            if(hashSet.size() == CAPACITY)
            {
               int last = dqueue.removeLast();
               hashSet.remove(last);
            }
        }else{
            dqueue.remove(page);
        }

        hashSet.add(page);
        dqueue.push(page);

    }
    public void display(){
       /* Iterator<Integer> iterator = dqueue.iterator();
        while(iterator.hasNext()){
            System.out.println("");
        }*/
        dqueue.stream().forEach(i -> System.out.println(i));
    }

    public static void main(String[] args) {

        LRUJava lruCache = new LRUJava(10);
        lruCache.refer(1);
        lruCache.refer(4);
        lruCache.display();

    }
}
