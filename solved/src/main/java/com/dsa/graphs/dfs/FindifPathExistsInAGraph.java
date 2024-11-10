package com.dsa.graphs.dfs;

import java.util.*;

/**
 * Conditions :  bi-directional graph with n vertices
 * 2D integer array edges
 * to find : valid path that exists from vertex source to vertex destination.
 * 
 * n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 *  Output: true
    Explanation: There are two paths from vertex 0 to vertex 2:
    - 0 → 1 → 2
    - 0 → 2
 */
public class FindifPathExistsInAGraph {
    
    List<java.util.List<Integer>> adjList = new ArrayList();
    boolean[] visited = new boolean[3];
    Stack<Integer> stack = new Stack<>();

    public static void main (String args[]) {

        int arr[][] = {{0,1},{1,2},{2,0}};
        int source = 0;
        int destination = 9;

        FindifPathExistsInAGraph path = new FindifPathExistsInAGraph();
        System.out.println(path.findPathExists(arr, source, destination));

    }

    private boolean findPathExists(int arr[][], int source, int destination) {

        for (int i=0; i < arr.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int [] edge : arr) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for(List<Integer> x : adjList) {

            for (int y : x) {

                System.out.println("value of x : " + x);
            }
        }

        Arrays.fill(visited, false);
        stack.push(source);
        //navigate from source and move to destination to check if the destination element occurs on pop

        while (!stack.isEmpty()) {

            int popedEle = stack.pop();
            visited[popedEle] = true;

            if (popedEle == destination) {
                return true;
            }
            if(visited[popedEle]){
                System.out.println("We have visited this element, we wont add neighbours of this element");
                continue;
            }
            for (int neighbour : adjList.get(popedEle)) {
                stack.push(neighbour);
            }
        }
        return false;
    }
}
