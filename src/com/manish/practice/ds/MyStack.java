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

    public static MyStack push(MyStack stack, int value){
        Node element = new Node(value);
        if(stack.top == null)
        {
            stack.top = element;
        }else{
            element.next = stack.top;
            stack.top = element;
        }
        return stack;
    }

    public static Node pop(MyStack stack){
        Node element = null;
        if(stack.top == null)
        {
            return stack.top;
        }else{
            element = stack.top;
            stack.top = element.next;
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
        push(stack, 1);
        push(stack, 2);
        push(stack, 3);
        push(stack, 4);
        push(stack, 5);
        System.out.println(pop(stack).data);
        while(stack.top != null)
        {
            System.out.print(stack.top.data+", ");
            stack.pop(stack);
        }
        System.out.println("\nTop");
        System.out.println(peek(stack));



    }
}
