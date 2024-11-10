package com.dsa.graphs.bfs;

import java.util.*;
public class FindIfPathExistsInAGraph {


    public static void main (String args[]) {

    }

    /**n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2 */
    private void bfsOfAGraph (List<List<Integer>> edges) {
      Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
      boolean visited[] = new boolean[edges.size()];
      //Adjacency list
      for (List<Integer> edge : edges) {
         if(adjacencyList.get(edge.get(0)) == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(edge.get(1));
            adjacencyList.put(edge.get(0), list);
         } else {
            List<Integer> list = adjacencyList.get(edge.get(0));
            list.add(edge.get(1));
            adjacencyList.put(edge.get(0), list);
         }
      }  
      Queue<Integer> queue = new LinkedList<>();
      adjacencyList.get(0);
      queue.add(edges.get(0).get(0));

      while (!queue.isEmpty()) {
        
        Integer edge = queue.poll();

        if(visited[edge]== true) {
            continue;
        }
        for (Integer neigh : adjacencyList.get(edge)){
            queue.add(neigh);
        }
        visited[edge] = true;
      }
      
      //This same algo can be used to find shortest path because its level order traversal and we will find source 
      //early because we completely search at a level first
    }
}
