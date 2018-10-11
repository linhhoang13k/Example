/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 1
 * 
 * Given a string, check if it is a Palindrome.
 */
public class MyCheckPalindrome {

	public static boolean checkPalindrome(String inputString) {

	    boolean flag = true;
	    char[] arr = inputString.toCharArray(); 
	    for(int i = 0; i<arr.length/2; i++){
	        if(arr[i]!=arr[arr.length-1-i]){
	            flag=false;
	        }
	    }
	    return flag;
	}
	public static void main(String args[]){
		System.out.println(checkPalindrome("aabbaa"));
	}
}
