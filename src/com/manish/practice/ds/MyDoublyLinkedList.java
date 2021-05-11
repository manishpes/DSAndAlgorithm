package com.manish.practice.ds;

public class MyDoublyLinkedList {

    static Node head = null;
    static int size = 0;
    static class Node
    {
        int data;
        Node prev;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.prev  = null;
            this.next = null;
        }
    }
    public static Node add(int value )
    {
        Node element = null;
        if(head == null){
            element = new Node(value);
            head = element;
        }
        else {
            Node temp  = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            element = new Node(value);
            temp.next = element;
            element.prev = temp;

        }
        size++;
        return element;
    }
    public static Node remove(int index )
    {
        Node element = null;
            Node temp  = head;
            int i = 0;
            while( i != index - 1)
            {
                temp = temp.next;
            }
            element = temp.next;
            temp.next = element.next;
            element.next.prev = temp;

        size--;
        return element;
    }
    public static void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        print();
    }
}
