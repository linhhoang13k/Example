package com.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zambro on 2/22/17.
 */
public class SmallestSubstringFinder {

    public static String findSmallestSubstring(String str, char[] arr) {
        int start = 0, end = 0;
        int uniqueCount = 0;
        String substring = null;

        //Load all characters in array to HashMap
        Map<Character, Integer> characterMap = new HashMap<>();
        for(char c : arr) {
            characterMap.put(c, 0);
        }


        for(start=0;start<str.length();start++) {
            char startCharacter = str.charAt(start);

            //Check if the character is in the arr
            if(characterMap.containsKey(startCharacter)) {
                int startCharacterCount = characterMap.get(startCharacter);
                //This is the first time this character is encountered in the window
                if(startCharacterCount == 0) {
                    uniqueCount++;
                }
                characterMap.put(startCharacter,startCharacterCount+1);

                //Lets try to shrink the window and still have all characters in arr.
                //This needs to be executed only when we have a minimum of all characters from arr.
                while(arr.length == uniqueCount) {
                    if(substring == null || (substring.length() > str.substring(end, start+1).length()))
                        substring = str.substring(end,start+1);

                    char endCharacter = str.charAt(end);
                    //If that end character is in the arr and unique, we need to decrement the unique count by 1
                    if(characterMap.containsKey(endCharacter)) {
                        int endCharacterCount = characterMap.get(endCharacter);
                        if(endCharacterCount == 1) {
                            uniqueCount--;
                            characterMap.put(endCharacter, 0);
                            end++;
                        } else {
                            characterMap.put(endCharacter, endCharacterCount-1);
                            end++;
                        }
                    } else {
                     end++;
                    }
                }
            }
        }

        return substring;
    }

    public static void main(String[] args) {
        String str = "aaaayzaxyyzaaa";
        char[] arr = {'x','y','z'};
        System.out.println(findSmallestSubstring(str, arr));
    }
}
