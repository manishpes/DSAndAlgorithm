package com.manish.practice.ds.tree;

public class FindSecondLargest {

    BTreeNode rootNode;

    FindSecondLargest(){
        rootNode = null;
    }
    class BTreeNode {

        int value;
        BTreeNode left, right;

        BTreeNode(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }

        BTreeNode insertLeft(int value) {
            this.left = new BTreeNode(value);
            return this.left;
        }

        BTreeNode insertRight(int value) {
            this.right = new BTreeNode(value);
            return this.right;
        }
    }

    public void insert(int value)
    {
        rootNode = insertNode(rootNode, value);
    }
    private BTreeNode insertNode(BTreeNode rootNode, int value){

        if(rootNode == null){
            rootNode = new BTreeNode(value);
            return rootNode;
        }
        if(value < rootNode.value)
          rootNode.left = insertNode(rootNode.left, value);

        if(value > rootNode.value)
            rootNode.right = insertNode(rootNode.right, value);

        return rootNode;
    }

    public int findSecondLargestElement(BTreeNode rootNode)
    {
        if(rootNode == null || (rootNode.left == null && rootNode.right == null)) // when tree is empty or only one
            // level
            return -1;

        if(rootNode.right!= null && (rootNode.right.left == null && rootNode.right.right == null)){ // when right &
            // left of rightmost tree is null i.e root of the rightMost is the secondLargest
            return rootNode.value;
        }
        if(rootNode.right == null && rootNode.left != null)
        {
            return maximaInLeft(rootNode.left);
        }

        return  findSecondLargestElement(rootNode.right);


    }

    private static int maximaInLeft(BTreeNode rootNode){
        int max = rootNode.value;
        while(rootNode != null)
        {
            max = rootNode.value;
            rootNode = rootNode.right;

        }
        return max;

        /*
            if(rootNode.right != null)
            maximaInLeft(rootNode.right);

            return rootNode.value;
         */

    }



    public static void main(String[] args) {

        /*
              10
          5         20
       3    7   15     25
                    22
                 21   23

         */
        FindSecondLargest rootNode = new FindSecondLargest();
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

        int secondLargest =  rootNode.findSecondLargestElement(rootNode.rootNode);

        System.out.println("The second largest element of the BST is :: "+ secondLargest);

    }
}

