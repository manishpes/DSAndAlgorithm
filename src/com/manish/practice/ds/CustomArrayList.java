package com.manish.practice.ds;

public class CustomArrayList {

    Node head = null;

    class Node
    {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data){
        Node newData = new Node(data);
        if(head == null)
        {
            head = newData;
            return;
        }
        Node curr = head;
        while(curr.next!= null){
            curr = curr.next;
        }
        curr.next = newData;
    }
    public boolean remove(int index){

        Node curr = head;
        Node prev = null;
        int count =0;
        while(curr != null && count != index  )
        {
            prev = curr;
            curr = curr.next;
            count++;
        }
        if(index == 0)
        {
            head = curr.next;
            return true;
        }
        if(count != index){
            return false;
        }
        if(count == index)
        {
            prev.next = curr.next;

        }

        return true;

    }
    public void print(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+", ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.remove(0);
        System.out.println("\nAfter removing");
        list.print();
//        List<Integer> list1 = new ArrayList<>();
//        list1.remove(1);

    }


}
