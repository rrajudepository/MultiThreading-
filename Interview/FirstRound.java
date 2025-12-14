package Interview;

import java.util.HashSet;
import java.util.Set;

public class FirstRound {

    public static boolean matchSubString(String s, Set<String> set, int startidx, int lastidx){
        System.out.println("startidx "+ startidx+ " lastidx "+ lastidx + " String length: "+ s.length());
        if(startidx == lastidx-1 && lastidx == s.length()+1){
           // System.out.println("start index: "+ startidx+ " last index: "+lastidx);
           return true;
        }

        if(startidx!=lastidx-1 && lastidx == s.length()+1){
            System.out.println("startidx "+ startidx+ " lastidx "+ lastidx+" String length"+ s.length());

            return false;
        }

        String s1 = s.substring(startidx, lastidx);
        boolean match = false;
        boolean notmatch = false;
        System.out.println("Subtstring: "+ s1);
        if(set.contains(s1)){
            System.out.println("Substring: "+ s1);
            match = matchSubString(s, set, lastidx, lastidx+1);
        }
           notmatch = matchSubString(s, set, startidx, lastidx+1);
    
        return (match || notmatch);
        
    }

    public static void main(String[] args) {
        /*
         * Problem Statement:
You are given a string s and a list of strings wordDict representing a dictionary.
Return true if s can be broken into a sequence of one or more words from the dictionary, separated by spaces.
 
You may reuse the same word from the dictionary multiple times.
 
Example 1:
Input:
s = "buttertoast"
wordDict = ["butter", "toast", "orange"]
Output:
true
Explanation:
The string can be segmented as "butter toast".
 
Example 2:
Input:
s = "bananaapplebanana"
wordDict = ["banana", "apple"]
Output:
true
Explanation:
The string can be segmented as "banana apple banana". The word "banana" is reused.
 
Example 4:
Example 3:
Input:
s = "cakedream"
wordDict = ["cake", "dreams", "ream"]
Output:
false
Explanation:
There is no valid way to segment the string using the given dictionary.
         */
         /*
          * s = abcd => a, b, c, d | a, b, cd | a,....
           0 to 10
           0 to 1 => 2 to =>/....<=
           0 to 2 => 3 to ......

           0 to n => length of string
           0 to i+1
             |
            i+2 to j
              |
              j+1 to k


              k+1 to n
              
          */

         String s = "bananaapple";
         String s2 = "bananaapplebanana";
         String s3 = "cakedream";


         String worddict[] ={"banana", "apple","gwava"};
         String worddict2[] ={"banana", "apple","ban"};
         String worddict3[] = {"cake", "dreams", "ream"};
         Set<String> wordSet = new HashSet<>();

         for(String curr : worddict3){
            wordSet.add(curr);
         }
         int startidx = 0;
         int lastidx = 1;

         boolean ans = matchSubString(s3, wordSet, startidx, lastidx);
         System.out.println("Subtring available in dict: "+ ans);




         /* 
          for(; lastidx<=s3.length(); lastidx++){
            String s1 = s3.substring(startidx, lastidx); //(0,4)
            if(wordSet.contains(s1)){
              //  System.out.println("substring: "+ s1);
                startidx = lastidx;
            }
          }
          //System.out.println(startidx+" : "+ lastidx);
          if(startidx == lastidx-1){
            System.out.println("true");
          }else{
            System.out.println("false");
          }

          */

        




    }
}
