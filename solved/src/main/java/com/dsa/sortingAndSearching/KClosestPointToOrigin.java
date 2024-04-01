package com.dsa.sortingAndSearching;

public class KClosestPointToOrigin {

    /*
     * Given an array of points where points[i] = [xi, yi] 
     * represents a point on the X-Y plane and an integer k 
     * return the k closest points to the origin (0, 0)
     * You may return the answer in any order. 
     * The distance between two points on the X-Y plane is the 
     * Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     * The answer is guaranteed to be unique (except for the order that it is in).
     * Input: points = [[1,3],[-2,2]], k = 1,  Output: [[-2,2]]
     * Looks like just use the formula to get the result
     * This is a sorting and searchibg
     */
    public static void main (String args[]) {
        KClosestPointToOrigin points = new KClosestPointToOrigin();
        points.KClosestPointToOrigin(null, 0);
    }

    /**
     * Brute force approach: find the sqrt of each point and then store the sqrt in a variable, then compare
     */
    private int[][] KClosestPointToOrigin(int[][] points, int k) {

        int nearestSqrt = 0;
        int ans [][] = new int [3][3];

        for (int row=0; row < points.length; row++) {
            for (int col = 0; col < points[row].length; col++) {
                System.out.println(points[row][col]);
            }
        }
        Math.sqrt(nearestSqrt)
        return ans;
    }
    
}
