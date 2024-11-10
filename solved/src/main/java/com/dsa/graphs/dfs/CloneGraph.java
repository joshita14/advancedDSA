package com.dsa.graphs.dfs;

import java.util.*;

/**Recursion DFS */
public class CloneGraph {

    class Node {
        int val;
        List<Node> neighbours;
        Node(int v, List<Node> neigh) {
            this.neighbours = neigh;
            this.val = v;
        }
    }

    public static void main (String args[]) {

    }

    private Node backtrackCloneGraphDFS(Node node, HashMap<Node, Node> map) {

        if(node == null) {
            return null;
        }
        if(map.containsKey(node)){
            return node;
        }

        Node newNode = new Node(node.val, new ArrayList<Node>()); //copy of new node
        map.put(node, newNode);

        for (Node neighbour : node.neighbours) {
            newNode.neighbours.add(backtrackCloneGraphDFS(neighbour, map));
        }
        return newNode;  //we return a final node thats the starting point in the hashmap
    }    
}

