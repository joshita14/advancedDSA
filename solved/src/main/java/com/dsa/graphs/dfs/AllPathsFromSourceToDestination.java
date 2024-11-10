package com.dsa.graphs.dfs;

import java.util.*;

/**
 * This problem cant be solved with stack
 * because stack will choose only 1 path while wallking
 * 
 * if you want to traverse all the paths recursion is needed
 */
public class AllPathsFromSourceToDestination {

    List<List<Integer>> adjList = new ArrayList();
    boolean visited[];
    public static void main (String args[]) {

        AllPathsFromSourceToDestination allPaths = new AllPathsFromSourceToDestination();
        int [][] edges = {{1,2},{3},{3},{}};
        allPaths.allPathsSourceToDest(edges);
    }

    private void allPathsSourceToDest(int paths[][]) {

        visited = new boolean[paths.length];
        for (int i=0; i < paths.length ; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int [] edge : paths) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();

        while (!stack.isEmpty()) {
            int popedEle = stack.pop();

            if(visited[popedEle] == true) {
                System.out.println("We have visited this node earlier");
                continue;
            }
            visited[popedEle] = true;


            for (int neighbour : adjList.get(popedEle)) {
                stack.push(neighbour);
            }
        }
    }

}
