package com.manish.practice.algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int a[], int l, int r)
    {

        if(l < r) {
            int pivot = r;
            int partition = partition(a, l, pivot , r);

            sort(a, l , partition - 1);
            sort(a, partition + 1 , r);
        }
    }
    private static int partition(int a[], int l, int pivot , int r){
        int pi = a[pivot];
        int partition = l;
          for(int i = l; i < r; i++)
          {
                if(a[i] < pi)
                {
                    swap(a , i, partition);
                    partition++;
                }
          }
        swap(a , r, partition);
        return partition;
    }


    public static void swap(int a[], int i, int pivot){

        int temp = a[i];
        a[i] = a[pivot];
        a[pivot] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Before Quick sorting ");
        Arrays.stream(arr).forEach(i -> System.out.print(i+", "));

        sort(arr, 0, arr.length-1);
        System.out.println("After Quick sorting ");
        Arrays.stream(arr).forEach(i -> System.out.print(i+", "));

    }

}
