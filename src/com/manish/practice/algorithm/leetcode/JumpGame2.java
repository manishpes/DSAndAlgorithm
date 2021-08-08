package com.manish.practice.algorithm.leetcode;

import java.util.Arrays;
import java.util.Map;

public class JumpGame2 {

    public static int JumpGame2No(int []nums)
    {
        int n = nums.length;
        int k = 4;
        int [] dp = new  int [n];
        Arrays.fill(dp, Integer.MAX_VALUE -1);
        dp[0] = 1;
        for(int i = 0; i <n; i++)
        {
            if(nums[i] != 0){
                for(int j = i+1; j<= i+k ; j++)
                {
                    if(j>=n)
                        break;
                    dp[j] = Math.min(dp[j], 1+dp[i]);
                }
            }
        }
        if(dp[n-1]== Integer.MAX_VALUE || dp[n-1] == Integer.MAX_VALUE-1)
        {
            return -1;
        }
        return dp[n-1];
/*
        int jumps = 0;
        int farthest = 0;
        int current_end = 0;
        for(int i=0;i<nums.length-1;i++) {
            farthest = Math.max(farthest,nums[i]+i);
            if(current_end==i)
            {
                jumps++;
                current_end = farthest;
            }
        }
        return jumps;*/
    }

    public static void main(String[] args) {
        int arr [] = new int[] {2,2,1,1,4,1};
        System.out.println(arr.length);
        System.out.println(JumpGame2No(arr));
    }

}
