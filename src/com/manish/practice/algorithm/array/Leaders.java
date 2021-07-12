package com.manish.practice.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class Leaders {

    public static void main(String[] args) {

        int arr [] =  new int [] {16,17,4,3,5,2};

       List<Integer> result = findLeader(arr, arr.length);
       result.forEach(i -> System.out.println(i));

    }
    private static List<Integer> findLeader(int arr[] , int n){

        List<Integer> res = new ArrayList<>();

        int localMaxima = Integer.MIN_VALUE;
        for(int i = n-1 ; i >=0; i-- )
        {
            if(arr[i] > localMaxima) {
                res.add(arr[i]);
                localMaxima = arr[i];
            }

        }

        return res;
    }
}
