import java.util.Arrays;
import java.util.Stack;

/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 3
 * 
 * You have a string s that consists of English letter, punctuation
 * marks, whitespace, characters, and brackets. It is guaranteed that 
 * that the parentheses in s form a regular bracket sequence. Reverse
 * the strings contained in each pair of the matching parentheses,
 * starting from the innermost pair. The result string should not contain
 * any parentheses.
 * 
 */

public class MyReverseParentheses {

	public static String reverseParentheses(String s) {

	    char[] chars = s.toCharArray();
	    Stack<Character> myStack = new Stack<Character>();
	    int openpar = 0;
	    int countStack = 0;
	    int parentCount = 0;
	    int r = 0;
	    int closepar = chars.length -1;
	    
	    //count number of parentheses
	    for(int i = 0; i<chars.length; i++){
	        if(chars[i]=='(' || chars[i]==')'){
	            parentCount++;
	        }
	    }
	    
	    //Loop through the amount of parentheses pairs
	    for(int k = 0; k<parentCount/2; k++){
	    
	        //Loop to find the inner most parentheses;
	        for(int i = 0; i<chars.length; i++){
	            if(chars[i]=='(' && i<closepar){
	                if(i>openpar){
	                    openpar=i;
	                }
	            }
	        
	            else if(chars[i]==')' && i>openpar){
	                if(i<closepar){
	                    closepar=i;
	                }
	            }
	        }
	    
	        //Put characters in parentheses into stack
	        for(int i = openpar + 1; i<closepar; i++){
	            myStack.push(chars[i]);
	            countStack++;
	        }
	    
	        //Empty stack and replace letters in chars[]
	        for(int j = 0; j<countStack; j++){
	            chars[1+j+openpar]=myStack.pop();
	        }
	        
	        //If there are  more than one pair of parentheses
	        if(parentCount/2>1){
	            char[] lessParent = new char[chars.length-2];
	            
	            //Get rid of parentheses
	            for(int z = 0; z<chars.length; z++){
	                if(openpar!=z && closepar!=z){
	                    lessParent[r]=chars[z];
	                    r++;
	                }
	            }
	            
	            chars = Arrays.copyOf(lessParent, lessParent.length);    
	            openpar=0;
	            countStack = 0;
	            closepar=chars.length -1;
	            r=0;
	        }
	        else{
	            char[] lessParent = new char[chars.length-2];
	            
	            //Get rid of parentheses
	            for(int z = 0; z<chars.length; z++){
	                if(openpar!=z && closepar!=z){
	                    lessParent[r]=chars[z];
	                    r++;
	                }
	            }
	            
	            chars = Arrays.copyOf(lessParent, lessParent.length); 
	        }
	    }
	    
	    String b = new String(chars);
	    return b; 
	}
	
	public static void main(String args[]){
		System.out.println(reverseParentheses("a(bc)de"));
	}

}
