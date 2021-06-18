package com.manish.practice.algorithm.leetcode;

import java.util.Arrays;

class MaxBlockSum {
    static int r, c;
    public int[][] matrixBlockSum(int[][] mat, int k) {

         r = mat.length;
         c = mat[0].length;
        int ans[][] = new int [r][c];
        for(int i =0;i<r;i++){
            for(int j = 0; j<c; j++ ){
             for(int x = -k ; x<= k ; x++ )
             {
                if(i+x >= 0 && i+x <r)
                {
                    int left = Math.max(j-k, 0);
                    int right = j+k+1;

                    ans[i+x][left] += mat[i][j];
                    if(right < c)
                        ans[i+x][right] -= mat[i][j];
//                    System.out.println(mat[i][j]+"  ans array x is "+x +"  " + (i+x) +"" +  left+"  "+ (i+x)+right);
                    printArray(ans);
                    System.out.println();
                }
             }
            }
        }

        for(int i =0;i<r;i++){
            int sum =0;
            for(int j = 0; j<c; j++ ){
                sum += ans[i][j];
                ans[i][j] = sum;
            }
        }
        return ans;
    }
    static void printArray(int [][] ans)
    {
        for(int i =0;i<r;i++){
            for(int j = 0; j<c; j++ ){
                System.out.print(ans[i][j]+", ");;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MaxBlockSum maxBlockSum = new MaxBlockSum();
        int mat[][] = new int [][] {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}};
        int ans[][] = maxBlockSum.matrixBlockSum(mat, 1);

        printArray(ans);

//        Arrays.stream(ans).forEach((i)-> Arrays.stream(i).forEach((j) ->
//                System.out.print(j+", ")));

    }
}
