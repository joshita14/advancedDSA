package com.dsa.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class MostCommonWords {
    /* There is a banned word, find the most common word which is not banned 
     * Example : paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
     * 
     * Edge case : if there are no banned words, means the list is empty and there is only 1 word in the array
     * then return that word
     * 
     * if there are no banned words then dont check for the banned condition
     * 
     * if there are banned word and you have a valid list size > 1 then go over the logic to find banned word
     * if there is comma as well after the string ex chick, consider the word
     * 
     * Banned can have any number of words [, , , , ,]
    */

    public static void main (String args []) {
        MostCommonWords cmnWords = new MostCommonWords();
        //String paragraphs = "Bob hit a ball, the hit BALL flew far after it was hit";
        String paragraphs = "a.";
        String [] banned = new String [] {"hit"};
        cmnWords.mostCommonWords(paragraphs, banned);
    }

    private String mostCommonWords(String paragraph, String[] banned) {
        /**
         * Algorithm: split by space
         * keep the list of words and their count in a map, frequency map
         * now iterate over the array of words and check if the map contains the banned word 
         * iterate over the map finally to find the highest count of un-banned word
         */

        HashMap<String, Integer> freqencyMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i=0; i < banned.length; i ++) {
            set.add(banned[i]);
        }

        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        String[] splitWords = normalizedStr.split("\\s+");
        System.out.println("Size of the splitted space : " + splitWords.length);

        if (splitWords.length == 1 && !set.contains(splitWords[0])) {
            System.out.println("We have only one word");
            return paragraph;
        }

        if (splitWords.length == 0) {
            return "";
        }

        for (int i = 0; i < splitWords.length ; i++) {
            String lowerCase = splitWords[i].toLowerCase();
            if(!set.contains(lowerCase)) {
                freqencyMap.put(lowerCase, freqencyMap.getOrDefault(lowerCase, 0)+1);
            }
        }

       int highestCount = 0; String stringFinalWords = "";
       for (Entry<String, Integer> entry : freqencyMap.entrySet()) {
        Integer currentCount = entry.getValue();   
        String currentString = entry.getKey(); 
        System.out.println("Key : "+ currentString + " currentCount : " + currentCount);  
        if(currentCount > highestCount) {
            highestCount = currentCount;
            stringFinalWords = entry.getKey();
        }
       }
       System.out.println("This is the word : " + stringFinalWords + " . this is the count : " + highestCount);
       return stringFinalWords;
    }
}
