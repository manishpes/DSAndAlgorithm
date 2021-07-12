package com.manish.practice.algorithm.leetcode;

import javafx.util.Pair;

import java.util.*;

public class KWeakestMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;
        int res[] = new int [k];
        int sum =0 ;

        List<Pair<Integer, Integer>> rowStrength  = new ArrayList<>();

        for(int i =0; i < m ;i++)
        {
            sum = Arrays.stream(mat[i]).sum();
            Pair<Integer, Integer> pair = new Pair<>(i, sum);
            rowStrength.add(pair);

        }

        Collections.sort(rowStrength, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ?  o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue();
            }
        });


        for (int i = 0; i < k; i++) {
            res[i] = rowStrength.get(i).getKey();
        }
        return res;


    }



}