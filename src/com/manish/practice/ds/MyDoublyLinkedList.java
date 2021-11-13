package com.manish.practice.ds;

public class MyDoublyLinkedList {

    Node head = null;
    int size = 0;
    class Node
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
    public  Node add(int value )
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
    public  Node remove(int index )
    {
        Node element = null;
            Node temp  = head;
            int i = 0;
           if(index == 0){
                head = head.next;
                head.prev = null;
                return head;
            }
            while( i != index-1)
            {
                temp = temp.next;
                i++;
            }
           element = temp.next;
            temp.next = element.next;
            if (element.next != null) {
                element.next.prev = temp;
            }
        size--;
        return element;
    }
    public void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyDoublyLinkedList dll = new MyDoublyLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.remove(1);
        dll.print();
        System.out.println();
        MyDoublyLinkedList dll2 = new MyDoublyLinkedList();
        dll2.add(4);
        dll2.add(5);
        dll2.add(6);
        dll2.print();
    }
}
