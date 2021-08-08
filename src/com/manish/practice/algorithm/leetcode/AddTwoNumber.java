package com.manish.practice.algorithm.leetcode;


import java.util.List;

/****
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * **/
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry =0;
        ListNode result = new ListNode();
        ListNode curr = new ListNode(0);
        result = curr;

        while(l1 != null && l2 != null){

            int sum = carry + l1.val + l2.val;
            carry = sum/10;
            ListNode res = new ListNode(sum%10);
            curr.next = res;
            curr = res;
           // print(result);
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null)
        {
            int sum = carry+l1.val;
            carry = sum/10;
            ListNode res = new ListNode(sum%10);
            curr.next = res;
            curr = res;
            l1 = l1.next;

        }
        while(l2 != null)
        {
            int sum = carry+l1.val;
            carry = sum/10;
            ListNode res = new ListNode(sum%10);
            curr.next = res;
            curr = res;
            l2 = l2.next;

        }
    if(carry != 0)
        curr.next = new ListNode(carry);
        return result.next;
    }

    private void print(ListNode l3){
        while(l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1  = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2  = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(9);
        AddTwoNumber sum = new AddTwoNumber();
       ListNode result = sum.addTwoNumbers(l1,l2);
        sum.print(result);
    }
}
