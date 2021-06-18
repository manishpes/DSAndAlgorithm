package com.manish.practice.ds.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFS {
    private int V;
    boolean vis[];
    private LinkedList<Integer>[] adj;

    DFS(int v)
    {
        V = v;
        vis = new boolean[V];
        adj = new LinkedList [V];
        for(int i =0; i < V; i++)
        {
            adj[i] = new LinkedList<>();
        }
        Arrays.fill(vis, false);
    }
    private void addEdge(int v, int e)
    {
        adj[v].add(e);
      //  adj[e].add(v);
    }


   private void DFSTraversal(int n)
    {
        vis[n]  = true;
        System.out.print(n + "  ");
        for(int i =0; i<adj[n].size();i++) {
            int edge = adj[n].get(i);
            if(!vis[edge]){
                DFSTraversal(edge);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFSTraversal(2);
    }

}
