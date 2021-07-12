package com.manish.practice.ds.tree;

public class KSmallestNode {

    class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Tree root;

    KSmallestNode(){
        root = null;
    }

    public void insert(int data)
    {
        root = insertNode(root, data);
    }
    private Tree insertNode(Tree root, int data){

        if(root == null)
        {
            Tree node = new Tree(data);
            root = node;
            return  root;
        }
        if(data < root.data){
            root.left = insertNode(root.left, data);
        }
        if(data > root.data){
            root.right = insertNode(root.right, data);
        }
        return root;
    }
/*    int count =0;
    private Tree kSmallestNode(Tree root, int k){
        if(root == null){
            return null;
        }
        Tree left = kSmallestNode(root.left, k);
        if(left != null)
            return left;

        count = count+1;
        if(k == count)
            return root;

       return kSmallestNode(root.right, k);

    }*/
    int countN = 0;
    public void findKSmallestElement(Tree rootNode, int k){

        if(rootNode == null || countN == k)
            return;

        findKSmallestElement(rootNode.left, k);
        countN += 1;
        if(countN == k)
        {
            System.out.println(String.format("The %d largest element of the BST is  %d ", k, rootNode.data));
        }

        findKSmallestElement(rootNode.right, k);
    }



    public static void main(String[] args) {
          /*
              10
          5         20
       3    7   15     25
                    22
                 21   23

         */
        KSmallestNode rootNode  = new KSmallestNode();
        rootNode.insert(10);
        rootNode.insert(5);
        rootNode.insert(20);
        rootNode.insert(3);
        rootNode.insert(7);
        rootNode.insert(15);
        rootNode.insert(25);
        rootNode.insert(22);
        rootNode.insert(21);
        rootNode.insert(23);
//        Tree ksmall = rootNode.kSmallestNode(rootNode.root, 2);
        rootNode.findKSmallestElement(rootNode.root, 1);
//        System.out.println("Using other method  " + ksmall.data);
    }

}
