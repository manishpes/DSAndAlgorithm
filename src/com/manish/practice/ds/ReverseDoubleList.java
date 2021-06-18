package com.manish.practice.ds;

public class ReverseDoubleList {

    public static void main(String[] args) {
        DList dList = new DList(1);
        DList dList2 = new DList(2);
        DList dList3 = new DList(3);
        DList dList4 = new DList(4);
        DList dList5 = new DList(5);

        dList.prev = null;
        dList.next = dList2;

        dList2.prev = dList;
        dList2.next = dList3;

        dList3.prev = dList2;
        dList3.next = dList4;

        dList4.prev = dList3;
        dList4.next = dList5;

        dList5.prev = dList4;
        dList5.next = null;

        printDList(dList);
        DList rev = reverseDList(dList);
        printDList(rev);


    }

    private static void printDList(DList dList) {
        System.out.println("\n The list is ");
        while(dList != null)
        {
            System.out.print(dList.data+"  ");
            dList = dList.next;
        }

    }
    private static DList reverseDList(DList head)
    {
        DList next = null;
        DList prev = null;
        DList curr = head;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
class DList{
    int data;
    DList next;
    DList prev;
    DList(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
