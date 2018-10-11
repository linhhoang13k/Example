/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
         str = str.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("str is : "+str);
        char[] input = str.toCharArray();
         int p1 = 0;
         int p2 = input.length-1;
        while(p1<p2){
            if(input[p1]!=input[p2]){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}