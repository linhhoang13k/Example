/*
Given the string, check if it is a palindrome.

Example

For inputString = "aabaa", the output should be
checkPalindrome(inputString) = true;
For inputString = "abac", the output should be
checkPalindrome(inputString) = false;
For inputString = "a", the output should be
checkPalindrome(inputString) = true.
Input/Output

[time limit] 3000ms (java)
[input] string inputString

A non-empty string consisting of lowercase characters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 105.

[output] boolean

true if inputString is a palindrome, false otherwise.
*/


boolean checkPalindrome(String inputString) {
	    Stack<Character> stack = new Stack<Character>();
	    Queue<Character> queue = new LinkedList<Character>();
	    for(int i = 0; i < inputString.length(); i++){
	        stack.push(inputString.charAt(i));
	        queue.add(inputString.charAt(i));
	    }
	    for(int i = 0; i < stack.size(); i++){
	        if(stack.pop() != queue.remove()){
	            return false;
	        }
	    }
	    return true;
}
