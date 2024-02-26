package com.dsa.array;
 public class IntegerToRoman { 

    public static void main (String args[]) {
        IntegerToRoman intToRoman = new IntegerToRoman();
        intToRoman.integerToRoman(20);
    }

    private void integerToRoman(int num) {
    //keep the numbers in a array : that simplifies the problem
    int values [] = new int [] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4 , 1};
    String[] symbol = new String [] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder sb = new StringBuilder ();
    for (int i=0; i < values.length; i++) {
        while (num >= values[i]) {
           num -= values[i];
           sb.append(symbol[i]);
        }
        //example : number 59, 59-50=9, 9-9=0, LIX
        //Let the number be 59, subtract the number from the smaller number : 59 -50 = 9, 9-5=4, 4-1=3, 3-1=2, 1-1=0    //LVIIII
    }
    System.out.println(sb.toString());
   }
}
