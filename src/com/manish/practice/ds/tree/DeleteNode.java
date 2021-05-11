package com.manish.practice.ds.tree;

public class DeleteNode {
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
    DeleteNode()
    {
        root = null;
    }
    void preOrderTaversal(){
       preOrderTaversal(root);
    }

    void deleteNode(int data){
       deleteTreeNode(root, data);
    }


    private void preOrderTaversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data+", ");
        preOrderTaversal(root.left);
        preOrderTaversal(root.right);
    }

    void insert(int data){
         root = insertNode(root, data);
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
    Node deleteTreeNode(Node root, int data)
    {
        if(root == null){
            return root;
        }
        if(data < root.data )
        {
          root.left =  deleteTreeNode(root.left, data);
        }
        else if(data > root.data )
        {
           root.right = deleteTreeNode(root.right, data);
        }
        else{

            if(root.left == null)
                return root.right;

            else if(root.right == null)
                return root.left;
            else{
                root.data = minValue(root.right);
                deleteTreeNode(root, root.data);
            }

        }

        return root;

    }

    private int minValue(Node root){
        int min = root.data;
        while(root.left != null ){
            min = root.data;
            root = root.left;
        }
        return  min;
    }
    public static void main(String[] args) {
        DeleteNode tree = new DeleteNode();
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(14);

        tree.preOrderTaversal();
        System.out.println();
        tree.deleteNode(14);
        System.out.println();
        tree.preOrderTaversal();
    }




}
