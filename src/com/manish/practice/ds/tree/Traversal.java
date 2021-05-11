package com.manish.practice.ds.tree;

public class Traversal {

    Node root;

    class Node {
        int data;
        Node left;
        Node right;
        Node(int val)
        {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    Traversal()
    {
        root = null;
    }

    void printInOrder(){
        inOrder(root);
    }
    void printPreOrder(){
        preOrder(root);
    }
    void printPostOrder(){
        postOrder(root);
    }
    void insert(int data){
       root = insertNode(root , data);
    }

    void inOrder(Node root){
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + ", ");
            inOrder(root.right);
        }

    }

    void preOrder(Node root){
        if(root != null) {
            System.out.print(root.data + ", ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    void postOrder(Node root){
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + ", ");
        }
        }

     Node insertNode(Node root, int data)
    {
         if (root == null)
         {
             root = new Node(data);
             return root;
         }

         if(data < root.data)
         {
             root.left = insertNode(root.left, data);
         }
        if(data > root.data)
        {
            root.right = insertNode(root.right, data);
        }

        return root ;
    }

    public static void main(String[] args) {
        Traversal tree = new Traversal();
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(14);

        tree.printInOrder();
        System.out.println();
        tree.printPreOrder();
        System.out.println();
        tree.printPostOrder();
    }

        /*10

      7          14

    5     9    12       17
  4   6      11  13   15     18
                         16 */
}


