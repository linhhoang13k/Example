/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
 

Example 2:

Input: 4
Output: "1211"
*/

class CountAndSay {
    public String countAndSay(int n) {
        String num = "1";
        for(int i=1; i<n; i++){
            num = find(num);
        }
        return num;
    }
    
    String find(String s){
        String result = "";
        int count = 0;
        char digit = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==digit){
                count++;
            }else{
                result += String.valueOf(count);
                result += (char)digit;
                count = 1;
                digit = s.charAt(i);
            }
        }
        result += String.valueOf(count);
        result += digit+"";
        
        return result;
    }
}