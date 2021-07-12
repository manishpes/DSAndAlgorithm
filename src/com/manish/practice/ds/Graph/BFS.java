package com.manish.practice.ds.Graph;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import java.util.*;

public class BFS {

    private int V;
    List<Integer>[] adj;

    BFS(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i =0; i < V; i++)
        {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v , int e)
    {
        adj[v].add(e);
        adj[e].add(v);
    }
    public void BFSTraversal(int v)
    {
        Queue <Integer> queue = new LinkedList<>();
        boolean visited [] = new boolean [V];
        visited[v]= true;
        queue.add(v);
       while(!queue.isEmpty()){
           v = queue.poll();
           System.out.print(v+  "  " );
           List <Integer> edge = adj[v];
           for(int i= 0; i <edge.size(); i++)
           {
            if(!visited[edge.get(i)]) {
                visited[edge.get(i)] = true;
                queue.add(edge.get(i));
             //   System.out.println(edge.get(i));
            }
           }
       }

    }

    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFSTraversal(2);

    }
}
