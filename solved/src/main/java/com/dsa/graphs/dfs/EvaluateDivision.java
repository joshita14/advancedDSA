package com.dsa.graphs.dfs;

import java.util.*;

public class EvaluateDivision {

    /**
     *  Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], 
     *  queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        Since a and b, pairs are given its a graph question

        its a directed weighted graph, DIRECTED is important
     */

     public static void main (String args[]) {

     }

     private void evaluateDivision(List<List<String>> edgesList, List<Double> inputList, List<List<String>> targetInputList) {
        //create a map with key and its pair as values and its solution
        //base conditions : if keys arent present in map, either of them, return -1 to answer list
        //if key and value are same return 1
        //for remaining ones do the calculation with each input get its pair from map

        Map<String, Map<String, Double>> inputMap = new HashMap<>();
        int count = 0;
        for (List<String> edge : edgesList) {
            String key1 = edge.get(0);
            String key2 = edge.get(1);

                Map<String, Double> subMap = new HashMap<>();
                subMap.put(key2, inputList.get(count));

                inputMap.put(key1, subMap);

                Map<String, Double> reverseSubMap = new HashMap<>();
                reverseSubMap.put(key1, 1/inputList.get(count));
                inputMap.put(key2, reverseSubMap);
                count++;
        }

        //Now take the inputMap for which the output has to be given
     }

     private void backtrackGivenGraph(Map<String, Map<String, Double>> inputMap, List<List<String>> targetEdges, List<Double> doubleList) {

        for (List<String> edges : targetEdges) {
            String key1 = edges.get(0);
            String key2 = edges.get(1);

            if(key1 == key2) {
                System.out.println("Key1 and key2 are equal answer is 1.0");
                doubleList.add(1.0);
            }
            if(inputMap.containsKey(key1) || inputMap.containsKey(key2)) {
                System.out.println("Either of the keys isnt present, returning -1.0 as output");
                doubleList.add(-1.0);
            } 

            //we have to call dfs now for rest of the keys, example ["a","c"],["b","a"],["a","e"]
        }
     }
    
     /**
      * Evaluate if their exists a path from dividend and divisor
      * @param dividend
      * @param divisor
      * @param inputMap
      */
     private void dfs(String dividend, String divisor, Map<String, Map<String, Double>> inputMap, List<Double> doubleList) {

        //Our purpose is to pupulate the double list
        Map<String, Double> dividendMap = inputMap.get(dividend);
        if(dividend == divisor) {
            doubleList.add(1.0);
            return;
        }

        if(!inputMap.containsKey(dividend) || !inputMap.containsKey(divisor)) {
            doubleList.add(-1.0);
            return;
        } 

        //travel dfs for soure and destination
        Double prodCal = 1.0;
        if (dividend == divisor) {
            System.out.println("We found the dstination we are looking for");
            return;
        }

        Map<String, Double> neighbours = inputMap.get(dividend);
        if(neighbours.containsKey(divisor)) {
            prodCal = prodCal * keyCal.getValue();
        } else {

        }
        for (Map.Entry<String, Double> keyCal : mp.entrySet()) {

             dfs(dividend, divisor, inputMap, doubleList);
        }
    
    }
}

1 , 2 , 3 , 4 , null

private void ll (Node<> ll) { 

    if(node.next || node ==null) {
        return node; //3
    }
    Node one = node;   //1, 3   
    Node secondNode = node.next(); //2, 4
    //sent : 3, null
    //return : 4
    backtrack(secondNode.next)
    swap(node, one)

    list

    1 1 2 3 5 8 13 21
    int ff (n) {

        if(n < 2) {g
            return n;
        }
        return ff(n-1) + ff(n-2);
    }