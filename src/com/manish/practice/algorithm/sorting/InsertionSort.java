package com.manish.practice.algorithm.sorting;

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int a[]){
    for(int i=1;i < a.length; i++){
        int j = i-1;
        int key = a[i];
        while(j >= 0 && a[j] > key)
        {
                a[j+1] = a[j];
                j--;

        }
        a[j+1] = key;

    }
    }

    public static void main(String[] args) {
        int a[] = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
        insertionSort(a);
        System.out.println("\n After Insertion sorting");
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
    }
}
