package com.manish.practice.prep;

import java.util.Arrays;

public class NoOfIsland {

    static int row = 0;
    static int col = 0;
    private static int noOfIsland(char[][] island) {
        int islands = 0;
        row = island.length;
        col = island[0].length;

        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(!visited[i][j] && island[i][j] == '1' ){
                    islands++;
                    helper(island, visited, i, j);
                }

            }
        }
        return islands;
    }
    private static void helper(char[][]island, boolean visited[][], int r, int c){
        if(r < 0 || c < 0  || r >= row || c >= col || visited[r][c] || island[r][c] == '0'){
            return;
        }
        visited[r][c] = true;
        helper(island,visited,r,c+1);
        helper(island,visited,r,c-1);
        helper(island,visited,r+1,c);
        helper(island,visited,r-1,c);

    }

    public static void main(String[] args) {
        char [][] island = new char [][]
                {
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                        };
        System.out.println(noOfIsland(island));

    }
}
