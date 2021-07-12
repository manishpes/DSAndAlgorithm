package com.manish.practice.prep;
public class MyPriortiyQueue {


    PriorityQueue head;

    MyPriortiyQueue(){
        head = null;
    }

    class PriorityQueue{

        int data;
        int priority; // lower value means higher priority
        PriorityQueue next;
        PriorityQueue(int data, int priority)
        {

            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }
    public int peek(PriorityQueue head){
        return head.data;
    }
    public PriorityQueue pop(){
        PriorityQueue pq = head;
        head = head.next;
        return pq;
    }
    public void push (int data, int priority){
        PriorityQueue node = new PriorityQueue(data, priority);
        PriorityQueue temp = head;
        if(head == null){
            head = node;
        }else
        if( priority < temp.priority )
        {
            node.next = head;
            head = node;
        }else{
            while(temp.next != null && temp.next.priority < priority)
            {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }
    public boolean isEmpty()
    {
        return head == null;
    }

    public static void main(String[] args) {


        MyPriortiyQueue pq = new MyPriortiyQueue();
        pq.push(4, 1);
        pq.push(5, 2);
        pq.push(6, 3);
        pq.push(7, 0);

        while (!pq.isEmpty()) {
            PriorityQueue priorityQueue = pq.pop();
            System.out.println(priorityQueue.data+"   "+ priorityQueue.priority);
        }
    }



}
