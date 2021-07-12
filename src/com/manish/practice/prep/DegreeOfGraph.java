package com.manish.practice.prep;

import java.util.ArrayList;
import java.util.List;

public class DegreeOfGraph {

        List<Integer>[] graph;
        int vertices;
        int inDegree [];
        int outDegree [];

        DegreeOfGraph(int vertices) {
            this.vertices = vertices;
            graph = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int vertex, int edge) {
            graph[vertex].add(edge);
            graph[edge].add(vertex);
        }

        public void degreeOfTheGraph(int v) {
             inDegree = new int[vertices];
             outDegree = new int[vertices];


            for(int i =0; i < vertices; i++)
            {
                List<Integer> edges = graph[i];
                outDegree[i] = edges.size();
                for(int j =0; j < edges.size(); j++ )
                {
                    inDegree[edges.get(j)]++;
                }
            }

        }
        public void printDegree ()
        {
            System.out.println("Vertex \t InDegree \t OutDegree");
            for(int i =0; i < vertices; i++){
                System.out.println(i+" \t "+inDegree[i]+ " \t "+ outDegree[i]);
            }
        }


    public static void main(String[] args) {
        DegreeOfGraph g = new DegreeOfGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.degreeOfTheGraph(0);
        g.printDegree();
    }

}
