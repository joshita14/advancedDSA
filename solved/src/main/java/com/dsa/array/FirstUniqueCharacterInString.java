package com.dsa.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class FirstUniqueCharacterInString {
    /* Given a string s, find the first non-repeating character in it and return its index. 
    If it does not exist, return -1. 
    iska matlab hai, if the next character is repeatitive then return the index of the previous one
    e is getting repeated
    Input: s = "leetcode"
    Output: 0


    Input: s = "loveleetcode"
    Output: 2
    Input: s = "aabb"
    Output: -1
    if all the characters are repeated then return -1
    */

    public static void main (String args []) {
        FirstUniqueCharacterInString f = new FirstUniqueCharacterInString();
        System.out.println(f.firstUniqueCharacterInString("loveleetcode"));
    }

    private int firstUniqueCharacterInString(String s) {
        int arr [] = new int[] {};
        //for () {}
        HashMap<Character, Integer> frequencyMp = new HashMap<Character, Integer>();
        for (int i =0; i < s.length() ; i++) {
            frequencyMp.put(s.charAt(i), frequencyMp.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i = 0; i < s.length() ; i++) {
             if (frequencyMp.get(s.charAt(i)) == 1) {
                return i;
             }
        }
        return -1;
    }
    
}
