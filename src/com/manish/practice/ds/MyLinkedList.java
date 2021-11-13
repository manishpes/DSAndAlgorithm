package com.manish.practice.ds;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
   Node head = null;
   Node tail = null;
   int size = 0;
   static class Node
    {
        int data;
        Node next = null;
        Node(int value)
        {
            this.data = value;
            this.next = null;
        }
    }
    public static MyLinkedList add (MyLinkedList list, int value)
    {
        if(list.head == null && list.tail == null)
        {
            list.head = new Node(value);
            list.tail = list.head;
        }
        else
        {
         Node element = new Node(value);
         list.tail.next = element;
         list.tail = element;
        }
        list.size++;
        return list;
    }
    public static MyLinkedList prePend (MyLinkedList list, int value)
    {
        if(list.head == null && list.tail == null)
        {
            list.head = new Node(value);
            list.tail = list.head;
        }
        else
        {
            Node element = new Node(value);
            element.next = list.head;
            list.head = element;
        }
        list.size++;
        return list;
    }

    public static Node remove (MyLinkedList list, int index)
    {
        Node toDelete = null;
        if(list.head == null && list.tail == null)
        {
            return null;
        }
        if(index < -1 || index > list.size  )
        {
            return null;
        }
        else {
            Node temp = list.head;
            int i = 0;
            while(i != index-1)
            {
                temp = temp.next;
                i++;
            }
            if(index == list.size-1)// last element
            {
                list.tail = temp;
            }
            toDelete = temp.next;
            temp.next = toDelete.next;
            list.size--;
        }
        return toDelete;
    }
   public static void printList(MyLinkedList list)
    {
        Node temp = list.head;
      while(temp != null){
          System.out.print(temp.data+", ");
          temp = temp.next;
      }
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        add(list, 1);
        add(list, 2);
        remove(list, 1);
        add(list, 3);
        prePend(list, 0);
        printList(list);
        List<Integer> lis = new LinkedList<>();

    }


}
