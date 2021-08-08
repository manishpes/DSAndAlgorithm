package com.manish.practice.algorithm.array;

class Solution {
    public static boolean judgeSquareSum(int c) {
        
        for(int i = 0; i <= Math.sqrt(c);i++)
        {
            
            if(Math.sqrt(c- i*i) == Math.floor(Math.sqrt(c- i*i)))
            {
                return true;
            }
        }
        return false;
        
    }

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(5));
//        System.out.println(Integer.MAX_VALUE);
    }
}