package com.dsa.array;

public class TrappingTheRainWater {
    
    /*
     * Given n non-negative integers representing an elevation map 
     * where the width of each bar is 1, compute how much water it can trap after raining.
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
     */
    public static void main (String args []) {
        TrappingTheRainWater tp = new TrappingTheRainWater();
        //int arr [] = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int arr [] = new int [] {4,2,0,3,2,5};
        System.out.println(" " +tp.trappingTheRainWater(arr));
    }

    /**
     * Simple logic
     * the building with lower height would be able to trap the water
     * so we need to find highest height from left and lowest height from right, so that we can find the
     * minimum of those heights and trap the water
     * When we do that we would be able to find difference b/w highest from left, such that water is trapped in b/w
     */
    private int trappingTheRainWater(int arr []) {

        //Create two auxillary arrays, left and right, we need to find whats the highest height from left to right
        //and from right to left
        int len = arr.length;
        int left [] = new int[len];  int right [] = new int[len];
        left[0] = arr[0];
        for (int i=1; i < len ; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }
        // 0,1,2,3,4,5
        right[len - 1] = arr[len-1];
        for (int i=len-2; i >= 0 ; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }    
       
        System.out.print(" left array : ");
        for (int i =0; i < left.length; i++) {
            System.out.print(" " +left[i]);
        } 
        System.out.print(" Right array : ");
        for (int i =0; i < right.length; i++) {
            System.out.print(" " +right[i]);
        }  
        int sum = 0;
        for (int i=0; i < len ; i++) {
            sum += Math.min(left[i], right[i]) - arr[i];
        }
      return sum;
    }
}
