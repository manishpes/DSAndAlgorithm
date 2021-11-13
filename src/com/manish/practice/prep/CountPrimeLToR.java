package com.manish.practice.prep;

import java.util.Arrays;

public class CountPrimeLToR {
    private int primeNumber( int L, int R) {

        int res = 0;


        boolean prime[] = new boolean[R + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < R; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= R; j = j+i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i < R; i++) {
            if (prime[i]) {
                res++;
            }
        }

        int prefixSum [] = new int[R+1];
        Arrays.fill(prefixSum, 0);
        for(int i=2; i<= R; i++){
            prefixSum[i] = prefixSum[i-1];
            if (prime[i])
                prefixSum[i]++;
        }

        return prefixSum[R] - prefixSum[L];



    }

    public static void main(String[] args) {
        CountPrimeLToR primeLToR = new CountPrimeLToR();
        int count = primeLToR.primeNumber(1,10);
        System.out.println(count);
    }
}
