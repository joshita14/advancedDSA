package com.dsa.graphs.bfs;

import java.util.*;

public class NoOfIslands {

    public static void main(String args[]) {
        NoOfIslands noOfIsland = new NoOfIslands();
    }

    private void noOfIsland(int [][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[grid[0][0]]);
        while (queue.isEmpty()) {
            
        
        }
    }

    private void bfs(int [][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[grid[row][col]]); 
        
        while (queue.isEmpty()) {
            
            List<int[]> neighbours = getNeighbours();

        }
    }

    private List<int[]> getNeighbours(int [][] directions, int row, int col, int[][] grid) {
        List<int[]> list = new ArrayList<>();

        for (int [] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newCol > grid[grid.length][grid[0].length] || grid[newRow][newCol] != 1) {
                continue;
            }
            list.add(new int[]{newRow, newCol});
        }
        return list;
    }

}
