package com.manish.practice.ds;

public class MyStack {
    Node top;
    static class Node{
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public  void push(int value){
        Node element = new Node(value);
        if(top == null)
        {
            top = element;
        }else{
            element.next = top;
            top = element;
        }
        //return stack;
    }

    public Node pop(){
        Node element = null;
        if(top == null)
        {
            return top;
        }else{
            element = top;
            top = element.next;
        }
        return element;
    }


    public static Node peek(MyStack stack){
        return stack.top;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "top=" + top +
                '}';
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.pop();
        stack.push( 1);
        stack.push( 2);
        stack.push(3);
        stack.push( 4);
        stack.push( 5);
        System.out.println(stack.pop().data);
        while(stack.top != null)
        {
            System.out.print(stack.top.data+", ");
            stack.pop();
        }
        System.out.println("\nTop");
        System.out.println(peek(stack));



    }
}
