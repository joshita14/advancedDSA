package com.dsa.array;

import javax.xml.crypto.KeySelector.Purpose;

/**
 * Leading zeros are not considered 1 and 001 and 00001 are same = 1
   If version1 < version2, return -1.
   If version1 > version2, return 1.
   Otherwise, return 0.
   check ones places, seconds place and then third place
   make a decision at each place, make a decision left to right
   this needs to be split by dot and then being compared
 */

 /**
  * Things to remember in this question
    the string with larger length needs to be navigated
    whatever is leftover you need to still move fwd
  */
public class CompareVersions {

    /**
     * input cases: 
     * 0.1 and 1.1
     * 0.1 and 0.002
     */
    
    public static void main (String args []) {
        CompareVersions ver = new CompareVersions();
        //String ver1 = "0.1";String ver2 = "1.1";
        //String ver1 = "1.1";String ver2 = "0.1";
        String ver1 = "1.1";String ver2 = "1.1";


        //version1 = "1.0", version2 = "1.0.0"   //version1 = "0.1", version2 = "1.1"
        int ans = ver.compareRev(ver1, ver2);
        System.out.println("This is the answer " + ans);
    }

    /**
     * At each step we have to compare, wherever we find a value > than the corroesponding value we immediately return 1, -1
     * Default case is 0
     * @param version1
     * @param version2
     * @return
     */
    private Integer compareRev (String version1, String version2) {

        String str1 [] = version1.split("\\.");
        String str2 [] = version2.split("\\.");
        int i =0;int j =0;

        while (i < str1.length && j < str2.length) {
            if(Integer.valueOf(str1[i]) > Integer.valueOf(str2[i])) {
                return -1;
            } else if (Integer.valueOf(str1[i]) < Integer.valueOf(str2[i])) {
                return 1;
            }
            i++;
            j++;
        }
        while (i < str1.length) {
            if(Integer.valueOf(str1[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (j < str2.length) {
            if(Integer.valueOf(str2[j]) > 0) {
                return -1;
            }
            j++;
        }
        return 0;
    }

    /**This approach will not work */
    private Integer compareRevsions (String version1, String version2) {
        //convert each string to integer, compare index to index and ignore the point/dots

        int i = 0;
        if (version1.length() >= version2.length()) { 
            while (i > version2.length() ) {
              if (Integer.valueOf(version1.charAt(i)) > Integer.valueOf(version2.charAt(i))) {
                return -1;
              } 
              i++;
            }
        } else {
            while (i > version1.length()) {
                if (Integer.valueOf(version1.charAt(i)) > Integer.valueOf(version2.charAt(i))) {
                    i++;
                  return -1;
                } 
                  i++;
              }
        }
        return 1;
    }
}
