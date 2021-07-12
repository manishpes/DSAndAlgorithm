package com.manish.practice.algorithm.array;

import java.util.Arrays;

public class SqrtProblem {

    private static boolean isPythagoasTriplet(int[] arr) {
        int m = 0;
        for (int i : arr) {
            arr[m] *= arr[m];
            m++;
        }
        Arrays.sort(arr);

        /*
            a^2 + b^2 = c^2
         */
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int c = arr[i];
            int j = 0;
            int k = i - 1;
            while (j < k) {
                int a = arr[j];
                int b = arr[k];
                if (a + b == c) {
                    System.out.println(a + "  " + b + " " + c);
                    return true;
                }
                if (a + b > c) {
                    k --;
                }else{
                    j++;
                }
            }
        }
    return false;
    }

    public static void main(String[] args) {

        int arr[] = { 3, 1, 4, 6, 5 };
        System.out.println(isPythagoasTriplet(arr));
    }
}
