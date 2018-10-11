package com.iub.coding.practice.CodeName47;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Paranthesis {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        Map<Character, Character> constant = new HashMap<Character, Character>();
	        constant.put('}', '{');
	        constant.put(')', '(');
	        constant.put(']', '[');
	        int len = 0;
	        
	        Stack<Character> stk = new Stack<Character>();
	        for(int a0 = 0; a0 < t; a0++){
	            String s = in.next();
	            len = s.length();
	            for(int i = 0; i < len; i++)    {
	                
	                if(constant.containsKey(s.charAt(i)))   {
	                   if(!stk.isEmpty() && constant.get(s.charAt(i)).charValue() == stk.peek().charValue())
	                       stk.pop();
	                    else   {
	                        stk.push(s.charAt(i));
	                        break;
	                    }
	                } else if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')  {
	                    stk.push(s.charAt(i));
	                }
	            }
	            
	            if(stk.isEmpty())
	                System.out.println("YES");
	            else
	                System.out.println("NO");
	            
	            stk = new Stack<Character>();
	            
	        }
	    }
}
