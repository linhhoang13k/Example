/**
 * Created by Trung on 3/28/2017.
 */
package Easy;

/**
 * Problem Statement:
 *      Given an integer, determine if it is a palindrome.
 * <p>Solution:
 *      <p>Own:     Convert integer to string.
 *                  Check each characters from both directions.</p>
 *      LeetCode:   Compare half digit in the number, so no overflow occurs.
 *
 * </p>
 */
public class _9_PalindromeNumberMain {


    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        else {
            String s = x +"";
            int i = 0, j = s.length() - 1;
            while (i < s.length() && j >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++; j--;
            }
        }
        return true;
    }

    public boolean _solution_isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;     //Example:  x = 1221
        int rev = 0;                                    //Loop:     1       rev = 1     x = 122
        while (x>rev){                                  //          2       rev = 12    x = 12
            rev = rev*10 + x%10;                        //Since rev = x --> 1221 is a palindrome.
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }


    public static void main(String...args) {
        System.out.println(isPalindrome(1231));
    }

}
