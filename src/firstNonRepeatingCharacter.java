package com.github.chen0040.codefights.arrays;


/**
 * Created by xschen on 3/8/2017.
 * Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

 Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

 Example

 For s = "abacabad", the output should be
 firstNotRepeatingCharacter(s) = 'c'.

 There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

 For s = "abacabaabacaba", the output should be
 firstNotRepeatingCharacter(s) = '_'.

 There are no characters in this string that do not repeat.

 Input/Output

 [time limit] 3000ms (java)
 [input] string s

 A string that contains only lowercase English letters.

 Guaranteed constraints:
 1 ≤ s.length ≤ 105.

 [output] char

 The first non-repeating character in s, or '_' if there are no characters that do not repeat.
 */
public class FirstNonRepeatingCharacter {
   public class Solution {
      char firstNotRepeatingCharacter(String s) {
         if(s.length()==0) return '_';
         int[] count = new int[256];
         int[] positions = new int[256];
         for(int i=0; i < s.length(); ++i) {
            int c = (int)s.charAt(i);
            count[c]++;
            if(positions[c] == 0) {
               positions[c] = i+1;
            }
         }
         int minPosition = s.length()+1;
         for(int i=0; i < count.length; ++i) {
            if(count[i] == 1) {
               if(minPosition > positions[i]) {
                  minPosition = positions[i];
               }
            }
         }

         if(minPosition == s.length()+1) {
            return '_';
         }
         return s.charAt(minPosition-1);
      }

   }

}
