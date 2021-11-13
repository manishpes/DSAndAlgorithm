package com.manish.practice.algorithm.array;

import java.util.Arrays;

public class ZerosToEnd {


    public static void main(String[] args) {

        int arr [] = new int[] {0,0,1,0,0,3};
//        zerosToEndN2(arr);
//       int res[] = zerosToEnd_O_N_Spaces(arr);

        zerosToEnd_O_N__1_Spaces(arr);
        System.out.println("\n After");
        Arrays.stream(arr).forEach(i -> System.out.print(i +" , "));
    }


    private static void zerosToEndN2(int arr [])
    {

        int n = arr.length;
        for(int i=0; i< n;i++){
            for(int j = i+1; j< n;j++){
                if(arr[i] == 0 && arr[j] !=0 )
                {
                        arr[i] = arr[j];
                        arr[j] = 0;
                }
            }
        }
    }

    private static int [] zerosToEnd_O_N_Spaces(int arr [])
    {

        int n = arr.length;
        int res[] = new int[n];
        int count =0;
        for(int i=0; i< n;i++){

            if(arr[i] != 0)
            {
                res[count++] = arr[i];
            }
        }
        while(count < n){
            res[count++] =0;
        }
        Arrays.stream(arr).forEach(i -> System.out.print(i +" , "));
        return res;
    }

    private static void zerosToEnd_O_N__1_Spaces(int arr [])
    {

        int n = arr.length;
        int count =0;
        for(int i=0; i< n;i++){

            if(arr[i] != 0)
            {
                arr[count++] = arr[i];
            }
        }
        while(count < n){
            arr[count++] =0;
        }
    }

}
