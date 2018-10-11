package com.utils;

public class ReverseParenthesis {
	public static void main(String args[]){
		String str= "The ((quick (brown) (fox) jumps over the lazy) dog)";
		StringBuilder sb = new StringBuilder(str);
		do{
		sb = substring(sb);
		
		}while(sb.toString().contains("("));
		System.out.println(sb.toString());	
	}
	
	public static StringBuilder substring(StringBuilder str){
		boolean flag = true;
		int indexb = str.lastIndexOf("(")+1;
		while(flag && indexb<str.length()){
			if(str.charAt(indexb)== ')'){
				flag = false;
			}else{
				indexb++;
			}
		}
		str.replace(str.lastIndexOf("("), indexb+1,reverse(str.substring(str.lastIndexOf("(")+1,indexb)));
		return str;	
	}
	public static String reverse(String str){
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
}
