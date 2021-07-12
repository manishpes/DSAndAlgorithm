package com.manish.practice.prep;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class RemoveKDigits {

    private static int removeKDigits(int number, int k)
    {
        String numStr = String.valueOf(number);
        Stack<Character> stack  = new Stack<>();
        int len = numStr.length();

        if(len <= k)
            return 0;

        for(int i =0; i < len ; i++){

            char ch = numStr.charAt(i);
            while(!stack.isEmpty() && stack.peek() > ch && k > 0 )
            {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        return Integer.parseInt(sb.toString());

    }
    public static void main(String[] args) {


        int input = 1432239;

        System.out.println(removeKDigits(input, 3));
    }
}
