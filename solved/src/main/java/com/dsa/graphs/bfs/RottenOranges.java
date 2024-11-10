package com.dsa.graphs.bfs;

import java.util.*;

public class RottenOranges {

    /*Input: grid = [[2,1,1],
                     00 01 02
                     [1,1,0],
                     10 11 12 
                     [0,1,1]
                     20 21 11
                     ] 
     Constraints : dont move diagonal only 4 directions, left, right, down and up
     Keep it in a constraint array and start moving based on that, for each row and column figure out where to move     
     Get neighbours on the fly! so that you dont have to store them anywhere          
    */
    public static void main (String args[]){
        /* 2 rotten, 1 fresh, minutes here represent in how many chances we can complete the traversal and destroy all fresh oranges
         * Input: grid = [
         * [2,1,1],
         * 00 01 02
         * [0,1,1],
         * 10 11 12
         * [1,0,1]
         * 20 21 22]
         *          
         * [(-1,-1)     (-1,0)   (-1,1)
         * ((0,-1)    x (0,0)    (0,1)
         *  (1, -1)     (1,0)    (1,1)
         * ]
         * 
         * whats the difference b/w when to write single [] and doubel [][]
         */

         RottenOranges rottenOranges = new RottenOranges();
         //int [][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
         //[2,1,1],[0,1,1],[1,0,1]
         int [][] arr = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
         System.out.println(rottenOranges.rottenOranges(arr));
    }

    private int rottenOranges(int [][] arr) {

        int [][] directions = {{0,-1}, {-1,0},{0,1},{1,0}}; //This is the final because it doesnt consider the diagonal
        /*
         *  if we find a rotten orange and we should move not diagonal but only 4 other sides and consider them as neighbour
         *  add them to the queue and move from there
         *  think about the logic what would you do if anyone reachable node is still left with 1
         */
         int rottenMinutes = 0;
         int freshOrange =0;
         boolean hasRotten = false;
         boolean [][] visited = new boolean[arr.length][arr.length];

         for (int i=0; i< arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if(arr[i][j]==1){
                    freshOrange ++;
                } 
            }
         }

         Queue<Integer []> queue = new LinkedList<>();
         if(arr.length == 0 || freshOrange== 0){
            return 0;
         }
         if(arr[0][0] != 2) {
            System.out.println("There are no rotten oranges to begin with");
            return -1;
         }
         queue.add(new Integer[]{0,0});
         while(!queue.isEmpty()){
            hasRotten = false;
            Integer [] element = queue.poll();
            int row = element[0];
            int col = element[1];
            
            for (int [] edges : directions) {
                int newRow = row + edges[0];
                int newCol = col + edges[1];

                if(newRow < 0 || newCol < 0 || newRow >=arr.length || newCol >= arr.length) {
                    continue;
                }
                if(arr[newRow][newCol] == 1 && visited[newRow][newCol] == false){
                       queue.add(new Integer[]{newRow, newCol});
                       visited[newRow][newCol] = true;
                       hasRotten = true;
                       arr[newRow][newCol] = 2;
                    }
                }
              if(hasRotten){
                 rottenMinutes++;
               }
            }
          for (int i=0; i< arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if(arr[i][j]==1){
                    return -1;
                } 
            }
         }
        return rottenMinutes;
    }
}
