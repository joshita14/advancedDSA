package com.dsa.graphs.dfs;

import java.util.*;

/**
 * This problem cant be solved with stack
 * because stack will choose only 1 path while wallking
 * 
 * if you want to traverse all the paths recursion is needed
 */
public class AllPathsFromSourceToDestinationBacktrack {

    List<List<Integer>> adjList = new ArrayList();
    boolean visited[];
    LinkedList<Integer> paths = new LinkedList<>();
    List<List<Integer>> results = new ArrayList();

    int currentNode;

    int target;
    public static void main (String args[]) {

        AllPathsFromSourceToDestination allPaths = new AllPathsFromSourceToDestination();
        int [][] edges = {{1,2},{3},{3},{}};
        allPaths.allPathsSourceToDestBacktrack(edges);
    }

    private void allPathsSourceToDestBacktrack(LinkedList<Integer> paths, int currentNode, int target, int [][] graph) {

        /* No concept of visited node */
       // visited = new boolean[paths.length];
       
       if(currentNode == target) {
           System.out.println("We found the destination");
           //add the path here
           results.add(new ArrayList<>(paths));
           return;
       }

       for (int neighbour : graph[currentNode]) {

            paths.addLast(neighbour);
            allPathsSourceToDestBacktrack(paths, neighbour, target, graph);

            //if from this path we found the condition as true,
            //Remove this neighbour once you have visited it and found the target from it\
            paths.removeLast();
       }
       
    }

    private LinkedList<Integer> allPathSourceToDesination (int [][] edge) {

        this.target = edge.length -1;
        this.currentNode = 0;
        LinkedList<Integer> path = new LinkedList<>();

        allPathsSourceToDestBacktrack(edge, currentNode, target, path);
        return path;
        
    }

}
