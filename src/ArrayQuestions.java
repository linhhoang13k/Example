package Interview;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayQuestions {
    // The array ONLY contains elements up to its length!
    // How do we "encode" the information, that we have seen a certain number?
    // Since all array elements are POSTIIVE, we make the value negative, where the index
    // was seen as a value before in the array.
    int firstDuplicate(int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[Math.abs(a[i]) - 1] < 0)
                return Math.abs(a[i]);
            else {
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
        return -1;
    }

    // Index of is linear in time word case O(s) in this case...
    char firstNotRepeatingCharacter1(String s) {
        char[] c=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.indexOf(c[i])==s.lastIndexOf(c[i]))
                return c[i];
        }
        return '_';
    }

}
