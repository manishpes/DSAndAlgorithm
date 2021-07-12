package com.manish.practice.ds.tree;

public class FindKLargestElement {

    BTreeNode rootNode;

    FindKLargestElement()
    {
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
    }
    public void insert(int value){

        rootNode = insertNode(rootNode, value);
    }

    private BTreeNode insertNode(BTreeNode rootNode, int value){
        if(rootNode == null){
            rootNode =  new BTreeNode(value);
            return rootNode;
        }

        if(value < rootNode.value)
        {
            rootNode.left = insertNode(rootNode.left, value);
        }

        if(value > rootNode.value)
        {
            rootNode.right = insertNode(rootNode.right, value);
        }

        return rootNode;
    }

    int count = 0;
    public void findKLargestElement(BTreeNode rootNode, Count c, int k){

        if(rootNode == null || count == k)
            return;

        findKLargestElement(rootNode.right, c, k);

        count += 1;
        if(count == k)
        {
            System.out.println(String.format("The %d largest element of the BST is  %d ", k, rootNode.value));
        }

        findKLargestElement(rootNode.left, c, k);


    }
    static class Count{
        int count = 0;

    }

    public static void main(String[] args) {

        FindKLargestElement rootNode  = new FindKLargestElement();
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
        Count c = new Count();
        int kthLargest  = 5;
        rootNode.findKLargestElement(rootNode.rootNode , c, kthLargest);

    }

}
