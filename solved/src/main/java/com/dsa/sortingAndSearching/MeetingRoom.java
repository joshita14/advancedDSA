package com.dsa.sortingAndSearching;

public class MeetingRoom {
    /**
     * Given an array of meeting time intervals where intervals[i] = [starti, endi], 
     * determine if a person could attend all meetings.
         Input: intervals = [[0,30],[5,10],[15,20]]
         Output: 2
 Are these Meetings one after another ? what does these random start and end numbers means ?
 Approach :
 Think about how we would approach this problem in a very simplistic way.
 We will allocate rooms to meetings that occur earlier in the day v/s the ones that occur later on, right?

 THESE ARE MEETING TIMES: 0.0 END 30 , 5AM HOURS ENDS 10 AM 15PM ENDS 20PM 
     */
     public static void main (String args []) {
        MeetingRoom mr = new MeetingRoom();
        mr.meetingRoom();
     }
    
     private boolean meetingRoom(){


        //empty array
        return true;
     }
}
