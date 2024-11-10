package com.dsa.graphs.bfs;
import java.util.*;

public class AllPathsFromSourceToDestBfs {

    /**
     * Input: graph = [[1,2],[3],[3],[]]
       Output: [[0,1,3],[0,2,3]]
     */
    public static void main (String args[]){

    }

    private void allPathsSourceToDestBfs(Map<Integer, List<Integer>> mp, int source, int target) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> paths = new ArrayList<>();
        if(source == target) {
           
        }
        List<Integer> neigh = mp.get(source);
        paths.add(source);
        while (!q.isEmpty()) {
            for (int negh : neigh){

            }
        }
    }
}
