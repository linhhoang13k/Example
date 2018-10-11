/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory,
since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it.
If there is no such character, return '_'.

Example

For s = "abacabad", the output should be
firstNotRepeatingCharacter(s) = 'c'.

There are 2 non-repeating characters in the string: 'c' and 'd'.
Return c since it appears in the string first.

For s = "abacabaabacaba", the output should be
firstNotRepeatingCharacter(s) = '_'.
*/

import java.util.LinkedList;
import java.util.List;

public class firstNotRepeatingChar {
    char firstNotRepeatingCharacter(String s) {
        int n = s.length();
        char[] data = new char[n];
        for(int i=0; i<n; i++) {
            data[i] = s.charAt(i);
        }
        List<Character> container = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(!container.contains(data[i])) {
                boolean hasDuplicate = false;
                for (int j = i + 1; j < n; j++) {
                    if (data[i] == data[j]){
                        container.add(data[i]);
                        hasDuplicate = true ;
                        break;
                    }
                }
                if(!hasDuplicate)  return data[i];
            }
        }
        return '_';
    }

}
