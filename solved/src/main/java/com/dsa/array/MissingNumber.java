package com.dsa.array;

import java.util.Arrays;

public class MissingNumber {

    //Return the only number missing from the array : [3, 0, 1]
    // missing number they are in range from 0 to n
    /**
     * Sort it and then find the missing, how, do you know expected sum ?
     * @param args
     */
    public static void main (String args []) {
      MissingNumber m = new MissingNumber();

      int nums [] = new int [] {1, 3, 0};
      //int nums [] = new int [] {11, 12, 14, 15, 16};
      //int nums [] = new int [] {1, 2};
      System.out.println(m.findTheMissingNumber(nums));
    }
    private Integer findTheMissingNumber(int[] nums) {
        Arrays.sort(nums);
        
        int rangeStart = 0;
        if (nums.length == 1) {
            rangeStart = 0;
        }
        int expectedSum = 0;
        int actualSum = 0;

        for (int i = 0; i <= nums.length; i++) {
            expectedSum = expectedSum + rangeStart;
            rangeStart++;
        }
       /* while (rangeStart <= rangeEnd) {
            expectedSum = expectedSum + rangeStart;
            rangeStart++;
        }*/
        for (int i = 0; i < nums.length ; i++) {
            actualSum = actualSum + nums[i];
        }
        return expectedSum - actualSum;
    }
    
}
