package com.manish.practice.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathsFromSrcToTarget {
    LinkedList<Integer>[] adj;
   static List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length;
        adj = new LinkedList[n];


        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<Integer>();
            for (int edge : graph[i]) {
                adj[i].add(edge);
            }
        }
       // printGraph();


      /*  for (int edge : adj[0]) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            path.add(edge);
            getAllPaths(edge, n - 1, path);
        } */

        List<Integer> path = new ArrayList<>();
        path.add(0);
        getAllPaths(0, n - 1, path);
        return  ans;
    }

    private void printGraph()

    {
        for(int i =0; i <adj.length; i++){
            for(int j = 0; j < adj[i].size(); j++ )
            {
                System.out.println(i +"-->"+ adj[i].get(j));
            }
        }
    }

    private void getAllPaths(int src, int dest, List<Integer> path) {
        if (src == dest) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int edge : adj[src]) {
            path.add(edge);
            getAllPaths(edge, dest, path);
            path.remove(path.size() -1);
        }
    }

    public static void main(String[] args) {
        PathsFromSrcToTarget tj = new PathsFromSrcToTarget();

        int[][] folks = new int[4][4];
        folks[0] = new int[]{1, 2};
        folks[1] = new int[]{3};
        folks[2] = new int[]{3};
        folks[3] = new int[]{};

        tj.allPathsSourceTarget(folks);

        for(List<Integer> path : ans)
        {
            path.stream().forEach(System.out :: print);
            System.out.println();
        }
    }

    public List<List<Integer>> allPathsSourceTarget_old(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(res, path, graph, 0);
        return res;

    }

    private void helper(List<List<Integer>> res, List<Integer> path, int[][] graph, int node) {
        if (node == graph.length - 1)  {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            path.add(graph[node][i]);
            helper(res, path, graph, graph[node][i]);
            path.remove(path.size() - 1);
        }

    }
}
