package com.manish.practice.ds.tree;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;


public class IsPairPresent
{

    static List<Integer> list = new ArrayList<>();
    Node root = null;
    public static void main(String[] args) {

        IsPairPresent tree = new IsPairPresent();
        tree.insert(10);
        tree.insert(7);
        tree.insert(8);
        tree.insert(15);
        tree.insert(12);
        tree.insert(13);

        List<Integer> list = tree.getList();
        list.forEach(i -> System.out.print(i+" "));

        boolean result = tree.isSumPresent(list, 23);
        System.out.println("\n Sum is present :: "+result);


    }
    private boolean isSumPresent(List<Integer> list, int sum)
    {

        int l = 0;
        int h = list.size() - 1;
        while(l < h)
        {
            int s = list.get(l);
            int e = list.get(h);


            if(s+e == sum)
                return true;
            if(s+e < sum)
                l++;
            else
                h--;
        }

        return false;
    }

    private void insert(int data)
    {
       root = insertNode(root, data);
    }

    private Node insertNode(Node root, int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }

        if(data < root.data)
            root.left = insertNode(root.left, data);
        else if (data > root.data)
            root.right = insertNode(root.right, data);

        return root;
    }


    private List<Integer> getList()
    {
        List<Integer> list = new ArrayList<>();
        return getListFromTree(root, list);
    }

   private List<Integer> getListFromTree(Node root, List<Integer> list){
        if(root == null)
            return list;
        getListFromTree(root.left, list);
        list.add(root.data);
        getListFromTree(root.right, list);
        return list;
    }



    class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}


