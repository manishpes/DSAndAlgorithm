package com.manish.practice.algorithm.leetcode;

import java.util.*;

public class TownJudge {

        public int findJudge(int n, int[][] trust) {

            int candidate [] = new int [n+1];
            if (n ==0)
                return -1;
            if(trust == null)
                return -1;
            Map<Integer, Integer> possibleJudge = new HashMap<>();
            Arrays.fill(candidate, 1);
            for(int [] can : trust)
            {
                int u = can[0], v = can [1];
                candidate[u] = 0;
                if(possibleJudge.containsKey(v))
                {
                    int count = possibleJudge.get(v);
                    possibleJudge.put(v, ++count);
                }else{
                    possibleJudge.put(v, 1);
                }
            }
            List<Integer> judge = new ArrayList<>();
            for(int i =1; i<=n;i++)
            {
                if((candidate[i] == 1) && (possibleJudge.get(i) ==n-1)){
                    judge.add(i);
                }

            }

            return judge.size() == 1 ?  judge.get(0) : -1;

        }

    public static void main(String[] args) {
        TownJudge tj = new TownJudge();
        int [][] folks = new int [3][3];
        folks[0] = new int[] {1, 3};
        folks[1] = new  int [] {2, 3};

        int judge = tj.findJudge(3, folks);
        System.out.println(judge);
    }
}
