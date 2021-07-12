package com.manish.practice.algorithm.leetcode;

import java.util.Arrays;

class CountPrimeNumber {
    public static int countPrimes(int n) {

        boolean prime [] = new boolean[n+1];
        Arrays.fill(prime, true);
        int res =0;
        for(int i =2; i*i <= n; i++)
        {
            if(prime[i])
            {
                for(int j = i*2; j<=n; j=j+i)
                {
                    prime[j] = false;
                }
            }
        }
        for(int i =2; i<n;i++)
        {
            if(prime[i])res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int res = countPrimes(5);
        System.out.println(res);
    }
}