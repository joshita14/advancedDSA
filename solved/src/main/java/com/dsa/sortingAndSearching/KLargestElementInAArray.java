package com.dsa.sortingAndSearching;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElementInAArray {


    public static void main (String args[]) {
        KLargestElementInAArray ll = new KLargestElementInAArray();
        int nums [] = new int []{3,2,1,5,6,4};
        System.out.println(ll.kLargestElement(nums, 2));
    }
    
    private int kLargestElement(int[] nums, int k){
       //edge case
       if (nums.length == 1) {
            return nums[0];
       }

       PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
       for (int i =0; i < nums.length ; i++) {
        pq.add(nums[i]);
        while(pq.size() > k) {
            System.out.println(" removed element " + pq.poll());
           }
       }
        System.out.println(pq.size());
        
        return pq.poll();
    }
}
