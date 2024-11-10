package com.dsa.graphs.bfs;

import java.security.KeyStore.Entry;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    /**
     * Input: grid = [[0,1],[1,0]]
       Output: 2, length is 2 because we have 0 and 0 in diagonal
       Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
       [ 1  0  0
        00 01 02
        1   1  0
        10 11 12 
        1   1  0 
        20 21 22  ]
     */
    public static void main(String args[]) {
      int arr[][]= {{1,0,0},{1,1,0},{1,1,0}};
      ShortestPathInBinaryMatrix matrix = new ShortestPathInBinaryMatrix();
      matrix.shortestPathInBinaryMatrix(arr);
    }

    private int shortestPathInBinaryMatrix(int[][] arr) {
        //put a condition that, if a[1][1]=0 then we have to accept in the list else no, create a adjacencyList 
        //and then do a bfs and check if we have a shortest path to reach end node in matrix
        Map<int[], List<int[]>> adjList = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr.length; j++) {
               
                //because we have to start with index that has 0 value and navigate to all other indexes with 0 values
                if(arr[i][j] == 0) {
                    System.out.println("points for ij "+ i + j +" ("+ arr[i][j]+")");
                /* [ 1  0  0
                    00 01 02
                    1   1  0
                    10 11 12 
                    1   1  0 
                    20 21 22  ] */
                    ArrayList<int[]> list = new ArrayList<>();
                    if(j < arr.length-1 && arr[i][j+1]==0) {
                        list.add(new int[]{i, j+1});
                    }
                    if(i < arr.length-1 && arr[i+1][j]==0){
                        list.add(new int[]{i+1, j});
                    }
                    if(j < arr.length-1 && i < arr.length-1 && arr[i+1][j+1]==0) {
                        list.add(new int[]{i+1, j});
                    }
                    if(i > 0 && arr[i-1][j] == 0){
                        list.add(new int[]{i-1, j});
                    }
                    /*if(arr[i+1][j+1]==0){}*/
                    if(j < arr.length-1 && arr[i][j+1]==0) {
                        list.add(new int[]{i, j+1});
                    }
                   /*  if(arr[i-1][j]==0 && i >0){
                        System.out.println("Repeated condition for cell number 10");
                    } */
                   /* if(arr[i+1][j] == 0){}
                      if(arr[i][j+1] == 0)  the condition is repeated */
                   /* if(arr[i+1][j+1]==0){} the condition is repeated */
                   /* if(arr[i-1][j]) the condition is repeated */
                   /* if(arr[i][j+1]) the condition is repeated */
                   if(j >0 && arr[i][j-1]==0) {
                    list.add(new int[]{i, j-1});
                   }
                   if(j>0 && i>0 && arr[i-1][j-1]==0){
                    list.add(new int[]{i-1, j-1});
                   }
                   /*if(arr[i+1][j])
                   if(arr[i+1][j+1])
                   if(arr[i][j+1]==0) the condition is repeated */
                   if(i > 0 && j < arr.length-1 && arr[i-1][j+1]==0){
                     list.add(new int[]{i-1, j+1});
                   }
                   adjList.put(new int[]{i,j}, list);
                }
            }
        }

        int distance =0 ;
        int[] source = new int[]{0,0};
        int[]   target = new int[]{arr.length-1, arr.length-1};
        //Do bfs now
        Queue<int[]> edgesOfMatrix = new LinkedList<>();
        edgesOfMatrix.add(source);

            while (!edgesOfMatrix.isEmpty()) {

                int[] element = edgesOfMatrix.poll();
                distance =+ 1;
                if(element == target){
                   System.out.println("reached from source to destination");
                   break;
                }
                for (int [] neighbour : adjList.get(element)){
                    edgesOfMatrix.add(neighbour);
                }
            }
        return distance;
    }

    private void bfs (int [][] grid, int row, int col) {
        int [][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        int distance = 0;
        while (!queue.isEmpty()) {
            int[] cell = queue.peek();
            List<int[]> neighbours = getNeighbours(direction, grid, cell[0], cell[1], distance);
            for(int[] neighbour : neighbours) {
                queue.add(new int[]{neighbour[0], neighbour[1]});
                distance = distance + 1;
            }
        }

        return distance;
    }

    private List<int[]> getNeighbours(int [][] directions, int [][] grid, int row, int col, int distance) {
        List<int[]> list = new ArrayList<>();
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newCol > grid.length -1 || grid[newRow][newCol] != 1) {
                continue;
            }
            list.add(new int[]{newRow, newCol});
            grid [newRow][newCol] = distance +1;
        }
        return list;
    }

    /*
     * 
     * class Solution {
    
    private static final int[][] directions = 
        new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        
        // Set up the BFS.
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        
        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }
        
        // The target was unreachable.
        return -1;
    }
    
    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length 
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;    
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours; 
    }
    
}
     */
}
