package com.manish.practice.ds.Graph;

import java.util.ArrayList;
import java.util.List;

class GraphCreation  {

    List<List<Integer>> adj ;

    GraphCreation(int V)
    {
        adj = new ArrayList<>(V);
        for(int i =0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }

    }
    public void addEdge(int v, int e)
    {
        adj.get(v).add(e);
        adj.get(e).add(v);
    }
    public void printEdge(){

        for(int i =0 ; i < adj.size(); i++)
        {
            for(int j =0; j< adj.get(i).size(); j++)
            System.out.println(i + " -> "+ adj.get(i).get(j));
        }
    }

    public static void main(String[] args) {
        GraphCreation graph = new GraphCreation(3);

        graph.addEdge(0,1);
        graph.addEdge(2,1);
        graph.printEdge();


        GraphCreation graph1 = new GraphCreation(2);

        graph1.addEdge(0,1);
//        graph1.addEdge(2,1);
        graph1.printEdge();


    }


}

