package com.manish.practice.algorithm.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int a[]){
        int n = a.length;
    for (int i = 0 ; i<n; i++ )
    {
        for(int j = 1; j<n-i; j++){
            if(a[j-1]> a[j]){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
    }

    public static void main(String[] args) {
        int a[] = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
        bubbleSort(a);
        System.out.println("\n After sorting");
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
    }
}
