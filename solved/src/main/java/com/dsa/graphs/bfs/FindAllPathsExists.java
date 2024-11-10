package com.dsa.graphs.bfs;

import java.util.*;

public class FindAllPathsExists {

    List<List<Integer>> result = new ArrayList<>();
    public static void main (String args[]){
        FindAllPathsExists allPaths = new FindAllPathsExists();
        int[][] arr = {{4,3,1},{3,2,4},{3},{4},{}};
        allPaths.bfs(arr);
    }
    //all possible paths
    private void bfs(int [][] arr) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            adjMap.put(i, list);
        }

        for (int i=0; i < arr.length; i++) {
            List<Integer> l = adjMap.get(i);
            for (int inte : arr[i]) {
                l.add(inte);
            }
        }

        //All Paths exits from source to dest, source=0 , destination=n-1
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        backtrack(adjMap, 0, arr.length-1, paths);
    }

    void backtrack (Map<Integer, List<Integer>> mp, int currentNode, int target, List<Integer> paths) {
         if(currentNode == target) {
            result.add(paths);
            return;
         }

         for (int node : mp.get(currentNode)) {
            paths.add(node);
         }
         backtrack(mp, currentNode, target, paths);
         paths.remove(paths.size()-1); //we will not cover this path again
    }  

}
