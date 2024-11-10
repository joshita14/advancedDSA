package com.dsa.graphs.bfs;

import java.util.*;
public class NarrayTreeLevelOrderTraversal {

    /**
     * Input: root = [1,null,3,2,4,null,5,6]
       Output: [[1],[3,2,4],[5,6]]
     * @param args
     */

    public static void main (String args[]) {


    }

    private void levelOrdertraversal(Node node) {

    //find out their parent level if the parent level is the same then they belong to same group
    //at each level update their child level , if they belong to same level then while traversal group them

        int arr[] = new int[1000];
        List<List<Node>> listOfNodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        arr[node.val] = 0;
        List<Node> list = new ArrayList<>();
        list.add(node);
        listOfNodes.add(list);

        while(queue.isEmpty()) {
            Node currentnode = queue.poll();
            for (Node child : node.children){
                arr[currentnode.val] += 1;

                if(listOfNodes.get(arr[currentnode.val])== null) {
                    System.out.println("This is the first time I am adding the node to the list");
                    ArrayList<Node> newL = new ArrayList<>();
                    newL.add(child);
                } else {
                    List<Node> l = listOfNodes.get(arr[currentnode.val]);
                    l.add(child);
                }
                queue.add(child);
            }
        }
    }
    // Definition for a Node.
   class Node {
        int val;
        List<Node> children;
        int level;
    
        Node() {}
    
        Node(int _val) {
            val = _val;
        }
        Node(int val, List<Node> children, int level) {
            this.val = val;
            this.children = children;
            this.level = level;
        }
        //children are given means traversal is given for traversing,need to find if they belong to same level
        //can we store parent level ? in each node as additional field?
    }

    //questions to ask while doing this : whats the input given ? is that simple that node and its children are given ?

    private List<List<Node>> nArrayTreeLevelOrderTraversal(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        if(root == null) {
            return null;
        }
        List<List<Node>> finalList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        root.level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int level = n.level;
            map.computeIfAbsent(level, k -> new ArrayList<>()).add(n);
            
            List<Node> neighbours = n.children;
            for(Node neighbour : neighbours) {
                neighbour.level = level + 1;
                queue.add(neighbour);
            }
        }
        //just print the map
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
     return finalList;
    }

    private List<List<Node>> nArrayTreeLevelOrderTraversal(Node root) {
        
        List<List<Node>> finalList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        List<Node> currentLevelNodes = root.children;
        
        while (currentLevelNodes.size() != 0) {
            
            List<Node> listofNodes = new ArrayList<>();
            List<Node> newLevels = new ArrayList<>();
            for (Node node : currentLevelNodes) {
                listofNodes.add(node);
                newLevels.addAll(node.children);
            }
            finalList.add(listofNodes);
            currentLevelNodes = newLevels;

        }
        return finalList;
    }
}

