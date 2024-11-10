package com.dsa.graphs.bfs;

import java.util.*;

public class PopulatingNextRightPointer {

    public static void main (String args[]) {
        PopulatingNextRightPointer pp = new PopulatingNextRightPointer();

        Node n7 = new Node(1, null, null, null);
        Node n6 = new Node(6, null, null, null);
        Node n5 = new Node();
        pp.populatingNextRightPointer(node);
    }

    private List<Node> populatingNextRightPointer(Node node) {
        /**
         * Level order traversal means traversing the levels of the tree
         * we have edge condition as root.next= null
         * we need to keep a check on level of the nodes as well, 
         * same level nodes can be linked together, we have to determine when level changes and if level changes push null
         * 
         * Input: root = [1,2,3,4,5,6,7]
           Output: [1,#,2,3,#,4,5,6,7,#]
         */
         List<Node> list = new ArrayList<>();
         Queue<Node> queue = new LinkedList<>();
         if(node == null) {
            return null;
         }

        queue.add(node);
        list.add(node);
        list.add(null);

     while (!queue.isEmpty() ) {
        Node ele = queue.poll();
        if(ele.left != null || ele.right != null) {
               if(ele.left != null) {
                  queue.add(ele.left);
                  list.add(ele.left);
               }
               if(ele.right != null) {
                   queue.add(ele.right);
                   list.add(ele.right);
                }
               list.add(null);
            }
        }
         return list;
       }
    /**
     * struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
    } */

    /**
     * Questions to ask yourself, why are the left and right pointers given ?
     */
    class Node {

        int v;
        Node left;
        Node right;
        Node next;

        Node(int val, Node left, Node right, Node next) {
            this.v = val;
            this.next = next;
            this.left = left;
            this.right = right;
        }
    }

    //Given a root node, head of the node 
    private void nextRightPointer(Node n, Node parent) {

        if(n.left == null && n.right == null) {
            return;
        }
        if(parent!= null && parent.right != null) {
            n.next = parent.right;
        }
        nextRightPointer(n.left, n);
        nextRightPointer(n.right, n);
    }

    private void finalAndCorrectApproach(Node root) {

        if(root == null) {
            return;
        }
        if(root.left != null) {
            root.left.next = root.right;
        }

        if(root.right != null && root.next != null) {
            root.right.next = root.right.left;
        }
        finalAndCorrectApproach(root.left);
        finalAndCorrectApproach(root.right);
    }
}
