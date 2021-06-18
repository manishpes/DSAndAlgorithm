package com.manish.practice.algorithm.array;

public class SearchRotatedSorted {
    static int search(int arr[], int l, int r, int key)
    {
     if( l>r )
         return -1;

     int mid = (l+r)/2;

     if(mid < r && arr[mid] == key)
        return mid;

     if(mid < r && arr[l] <= arr[mid] && key >=arr[l] && key < arr[mid] )
     {
         return search(arr, l, mid, key);
     }

     return search(arr,mid+1, r, key);

    }

    public static void main(String[] args) {
    int arr[] = new int []{3, 4, 5, 1, 2 };
        System.out.println(search(arr, 0, 5, 5));
    }
}
