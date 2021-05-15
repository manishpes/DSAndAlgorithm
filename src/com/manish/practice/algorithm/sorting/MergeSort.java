package com.manish.practice.algorithm.sorting;

import java.util.Arrays;

public class MergeSort {

    private static void mergesort(int a[], int l , int h)
    {
        if(l < h)
        {
            int mid = l+ (h-l)/2;
            mergesort(a, l, mid);
            mergesort(a, mid+1, h);
            merge(a, l , mid,  h);
        }
    }
    /*void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        *//* Create temp arrays *//*
        int L[] = new int[n1];
        int R[] = new int[n2];

        *//*Copy data to temp arrays*//*
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        *//* Merge the temp arrays *//*

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        *//* Copy remaining elements of L[] if any *//*
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        *//* Copy remaining elements of R[] if any *//*
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }*/

    private static void merge(int[] a, int l , int m , int h)
    {
       // int mid = (l+h)/2;

        int n1 = m - l + 1;
        int n2 = h - m;


        int left [] = new int [n1];
        int right [] = new int [n2];

        for (int i = 0; i < n1; ++i)
            left[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = a[m + 1 + j];

        int i =0, j =0;

        int k = l;
        while(i<n1 && j < n2)
        {
            if(left[i] <= right[j])
            {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            a[k] = left[i];
            i++;
            k++;
        }

        while(j < n2){
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int a[] = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
        mergesort(a, 0, a.length -1 );
        System.out.println("\n After MergeSort sorting");
        Arrays.stream(a).forEach(i ->{
            System.out.print(i+", ");
        });
    }
}
