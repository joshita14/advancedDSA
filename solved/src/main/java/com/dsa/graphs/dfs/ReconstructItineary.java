package com.dsa.graphs.dfs;

import java.util.*;
import java.util.Map.Entry;
public class ReconstructItineary {

    /**
     * The first problem in this question is a raph isnt given, we need to first form a graph, means an adjacency list of
     * who is connected to who, this is a string question which can be solved with help of hashmap
     * 
     * 
     * For our airports problem we have two crucial points we must put in mind: We must use each ticket once and only once, 
     * there is atleast one valid itinerary as a solution of the problem.
     */

    public static void main (String args[]) {

        ReconstructItineary itineary = new ReconstructItineary();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        itineary.reconstructItineary("JFK", map);
    }

   
   /*  private List<List<String>> reconstructItineary (List<List<String>> tickets) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        HashMap<String, List<String>> flightMap = new HashMap<>();
        boolean [] visited = new boolean[];

        for (List<String> ticket : tickets) {

            String source = ticket.get(0);
            String destination = ticket.get(1);

            if(flightMap.get(source) == null) {
                LinkedList<String> ll = new LinkedList<>();
                ll.add(destination);
                flightMap.put(source, ll);
            } else {
                LinkedList<String> destList = new LinkedList<>();
                destList.add(destination);
                flightMap.put(source, destList); 
            }
        }

        //We could have used priority queue instead of Linkedlist that would have prevented us from doing a lexical sorting later
        for (Entry<String, List<String>> key : flightMap.entrySet()) {

            Collections.sort(key.getValue());
        }
        LinkedList<String> paths = new LinkedList();
        paths.add("JFK");
        return result;
    } */

    private List<String> reconstructItineary(List<List<String>> tickets) {

        List<String> paths = new ArrayList<>();

        Map <String, PriorityQueue<String>> flightMap = new HashMap<>();

        for (List<String> ticket : tickets) {

            String source = ticket.get(0);
            String destination = ticket.get(1);

            if(flightMap.get(source) == null ) {

                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.add(destination);
                flightMap.put(source, queue);
            } else {
                PriorityQueue queue = flightMap.get(source);
                queue.add(destination);
                flightMap.put(source, queue);
            }
        }

        backtrackingItineary(flightMap, paths, "JFK");
        return paths;
    }

    private List<String> backtrackingItineary (Map<String, PriorityQueue<String>> flightQueue, List<String> paths, String currentNode) {

        PriorityQueue<String> pq = flightQueue.get(currentNode);

        while (pq != null || pq.isEmpty()) {
            
            String node = pq.poll(); //only polling the top node and then traversal from that
            backtrackingItineary(flightQueue, paths, node);
        }
        paths.add(0, currentNode); //adding always on the 0 index makes JFK becomes the first city
        return paths;
    }

    //This approach has an issue, lets say the from the second element in the queue we can go anywhere else
    //then we reached dead end, in that case we would be doing nothing in queue because queue is empty, if this
    //would have been recursion we would have come back to the first node and then take it from there..
private List<String> reconstructItineary(String currentNode, Map<String, PriorityQueue<String>> map) {

        List<String> finalList = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
           String city = queue.poll();
           finalList.add(city);

           PriorityQueue<String> q = map.get(city);
           queue.add(q.poll());
        }
        return finalList;
    }

    private List<String> backtrackingReconstructItineary(String currentNode, Map<String, PriorityQueue<String>> mapWithPq) {

        List<String> itineary = new ArrayList<>();
        PriorityQueue<String> pq = mapWithPq.get(currentNode);
        if(!pq.isEmpty()  || pq!=null) {
            backtrackingReconstructItineary(pq.poll(), mapWithPq); 
            //here when we reach last, bktr will take care of moving from last to secondlast
        }
        itineary.add(0, currentNode);
    }
}
