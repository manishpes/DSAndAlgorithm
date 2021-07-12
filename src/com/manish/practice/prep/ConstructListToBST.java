package com.manish.practice.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructListToBST {

    class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Tree constructTree(List<Integer> list, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high)/2;
        Tree root = new Tree(list.get(mid));
        root.left = constructTree(list, low, mid - 1);
        root.right = constructTree(list, mid + 1, high);
        return root;
    }

    static class Index{
        int i = 0;
    }
    Tree sortedListToBSTRecur(List<Integer>list, int n, Index index)
    {
        if (n <= 0)
            return null;

        Tree left = sortedListToBSTRecur(list, n / 2, index);
        Tree root = new Tree(list.get(index.i));
        root.left = left;
//        head = head.next;
        index.i++;
        root.right = sortedListToBSTRecur(list, n - n / 2 - 1, index);
        return root;
    }

    public void inOrder(Tree root){
        if(root!= null)
        {
            inOrder(root.left);
            System.out.print(root.data+" , ");
            inOrder(root.right);
        }

    }


    public static void main(String[] args) {

        List<Integer> list = Stream.of(10,15,20,25,28,29,30).collect(Collectors.toList());
        ConstructListToBST cbst = new ConstructListToBST();

//        Tree root = cbst.constructTree(list, 0, list.size()-1 );
        Index index = new Index();
        Tree root = cbst.sortedListToBSTRecur(list, list.size(), index );
        cbst.inOrder(root);
    }
}
