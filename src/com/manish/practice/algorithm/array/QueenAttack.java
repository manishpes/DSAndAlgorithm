package com.manish.practice.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueenAttack {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int ans = 0;
        Set<String> obsSet = new HashSet<>();
        for (int i=0; i <obstacles.size(); i++)
        {
            obsSet.add(obstacles.get(i).get(0)+":"+ obstacles.get(i).get(1));

        }
        ans +=  totalAllowedMoves(n, r_q, c_q, 0, 1, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, 0, -1, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, 1, 0, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, -1, 0, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, -1, -1, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, -1, 1, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, 1, 1, obsSet);
        ans +=  totalAllowedMoves(n, r_q, c_q, 1, -1, obsSet);

        return ans;
    }
    private static int totalAllowedMoves(int n, int r_q, int c_q, int rr, int cc, Set<String> obs )
    {
        int r = r_q + rr;
        int c = c_q + cc;
        int ans = 0;
        while(valid(n,r, c) && !obs.contains(r+":"+c))
        {
            r = r + rr;
            c = c + cc;
            ans++;
        }
        return ans;
    }
    private static boolean valid(int n , int r, int c)
    {
        return (r<=n && r>0) && (c<=n && c>0);
    }

    public static void main(String[] args) {
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obs = new ArrayList<>();
        obs.add(5);
        obs.add(5);
        obstacles.add(obs);

        List<Integer> obs2 = new ArrayList<>();
        obs2.add(4);
        obs2.add(2);
        obstacles.add(obs2);

        List<Integer> obs3 = new ArrayList<>();
        obs3.add(2);
        obs3.add(3);
        obstacles.add(obs3);


        int total_moves = queensAttack(5, 3, 4, 3, obstacles);
        System.out.println("Total number of allowed Moves for a queens:: "+ total_moves);

    }
}
