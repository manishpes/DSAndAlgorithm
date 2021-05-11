package com.manish.practice.algorithm.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int a[]){
        int n = a.length;
        for(int i = 0; i <n ; i++){
            int min = i;
            for(int j =i+1; j<n;j++){
                if(a[min] > a[j])
                {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int a[] = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
        selectionSort(a);
        System.out.println("\n After sorting");
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
    }
}
