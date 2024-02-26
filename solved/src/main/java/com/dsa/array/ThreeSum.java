package com.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     Input : Input: nums = [-1,0,1,2,-1,-4]
             Output: [[-1,-1,2],[-1,0,1]]
     Input: nums = [0,1,1]
     Output: []     
     
     SORT SORT SORT
     Sorting the array element is important, we dont want to repeat the tripplets
     and also for comparision it would be good.
     start condition is for skipping duplicate
     Time complexity n2
     */

     public static void main(String args[]) {

        ThreeSum ths = new ThreeSum();

        //int arr [] = new int[] {-1,0,1,2,-1,-4};
        //Just giving sorted output for now
        int arr [] = new int[] {-4,-1,-1,0,1,2};
        
        ths.threeSum(arr, 0);
     }

     private void threeSum (int [] arr, int target) {
        StringBuilder sb = new StringBuilder();
        int leftOverSum = 0;
        java.util.List<Integer> l = new ArrayList();
        java.util.List<List<Integer>> finalList = new ArrayList<>();
        for (int start=0; start < arr.length -1 ; start++) {
            int low = start + 1;
            int high = arr.length - 1;
            //Condition to skip duplicates
            if(start > 0 && arr[start-1] != arr[start] ) {
            while(low < high) {
                if (arr[high] + arr[low] + arr[start] == target) {
                    List<Integer> targetList = new ArrayList<>();
                    targetList.add(arr[start]);
                    targetList.add(arr[low]);
                    targetList.add(arr[high]);
                    sb.append(targetList);
                    low++;
                    high--;
                } else {
                    if(arr[high] + arr[low] > leftOverSum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
          }
        }
        System.out.println(sb.toString());
     }
}
