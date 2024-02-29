package com.dsa.array;

import java.util.Arrays;
import java.util.Map.Entry;

import javax.swing.UIDefaults.ProxyLazyValue;

public class GroupAnangrams {
    
    public static void main (String args[]) {

        GroupAnangrams grpAnagrams = new GroupAnangrams();
        String [] str = new String [] {"eat","tea","tan","ate","nat","bat"};
        grpAnagrams.groupAnagrams(str);
    }

    private void groupAnagrams(String arr[]) {
        java.util.List<java.util.List<String>> list = new java.util.ArrayList<>();
        java.util.Map<String, java.util.List<String>> mp = new java.util.HashMap<>(); //map to keep sorted string as key

        for (int i=0; i < arr.length; i++) {
            char [] ch = arr[i].toCharArray(); //To be memorized
            Arrays.sort(ch);
            String sortedList = String.valueOf(ch);
            if (!mp.containsKey(sortedList)) {
                java.util.List l = new java.util.ArrayList<>();
                l.add(arr[i]);
                mp.put(sortedList, l);

            } else {
                mp.get(sortedList).add(arr[i]);
            }
        }
        for (Entry<String, java.util.List<String>> m : mp.entrySet()) {
              System.out.println(m.getValue());
              list.add(m.getValue());
              //we can add this to a final output list
        }
        System.out.println(list.toString());
    }
}
