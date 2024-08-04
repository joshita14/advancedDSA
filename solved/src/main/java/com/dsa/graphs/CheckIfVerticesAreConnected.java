package com.dsa.graphs;

public class CheckIfVerticesAreConnected {

    static int x = 5;
    static int root[] = new int[x];
    public static void main(String args[]) {
        for (int i=0; i < 5; i++) {
            root[i] = i;
        }

        union(1, 2);
        union(2, 5);
        union(5, 6);
        union(6, 7);
        union(3, 8);
        union(8, 9);

    }

    private static int find(int x) {
        return root[x];
    }

    /**
     * function does the update of the parent of each vertex
     * @param vertex1
     * @param vertex2
     */
    private static void union(int vertex1, int vertex2) { 
        //(1,2)
        int x = find(vertex2);
        int y = find(vertex2);
        if(vertex1 != vertex2) {
            for (int i=0; i < root.length ; i++) {
                if(root[i] == y ) { //we reached the actual node whose parent needs to be updated
                    root[i] = x; //updating the parent of the vertex2/y
                }
            }
        }
    }

    private static boolean isConnected(int x, int y) {
        //this means : find the node, run union this will parent for in the child, just find from index if both parents are same
        if(find(x) == find(y)){
            return true;
        } else {return false;}

        //if parents to both nodes are same return true
    }


}
