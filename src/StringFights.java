/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewPracticeProblems;

/**
 *
 * @author BigBoss
 */
public class StringFights {    
    public static String amendTheSentence(String s) {
        String str;
        str = s.replaceAll("(?!^)([A-Z])", " $1");
        for(int i = 0; i < str.length() ;i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                str = str.replace(str.charAt(i), Character.toLowerCase(str.charAt(i)));
            }
        }            
        return str;
    }
    
    /**
     * Returns the index from where the substring was first located in 
     * the main string.
     * @param s Main string
     * @param x Substring to look for in main string
     * @return Index of substring
     */
    public static int findFirstSubstringOccurrence(String s, String x) {        
        int index = -1;
        int mainIndex = 0;
        int check1 = -1;
        int check2 = -1;
        int startIndexOfCheck2 = 0;
        final int mainLen = s.length();        
        final int subLen = x.length();
        final int subEnd = subLen - 1;
        
        // If there's only 1 character in the main string, we only compare 
        // against the one and only character.
        if (mainLen == 1)
            if (s.charAt(mainIndex) == x.charAt(0))
                return 0;      
            else 
                return -1;
        
        // If substring is only 1 charcter, then we have to iterate through
        // the entire main string until we find a match.
        if (subLen == 1) {
            for(int j = 0; j < mainLen; j++)
                if(s.charAt(j) == x.charAt(0))
                    index = j;
        }
        else 
            while(mainIndex + subEnd < mainLen && index == -1) {
              // Check first and last character of substring with main string
              // If there's a match, we iterate through the middle and compare.
              // If no match, we shift the substring over
              if (s.charAt(mainIndex) == x.charAt(0) && 
                  s.charAt(mainIndex + subEnd) == x.charAt(subEnd)) {
                  int subIndex = 1;
                  for(int i = mainIndex+1; i <= mainIndex+subEnd; i++,subIndex++) {                     
                      if (i == mainIndex + subEnd) {
                          index = mainIndex;
                          break;
                      }

                      if (s.charAt(i) != x.charAt(subIndex)) {
                          mainIndex++;
                          break;                              
                      }
                  }
              } else {
                  mainIndex++;
                  continue;
              }
            };  
        return index;
    }  
    
}
