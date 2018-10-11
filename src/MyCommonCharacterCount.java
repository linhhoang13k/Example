/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 3
 * 
 * Given two strings, find the number of common characters
 * between them.
 * 
 */
import java.util.Arrays;

public class MyCommonCharacterCount {
	
	public static int commonCharacterCount(String s1, String s2) {

	    char[] ars1 = s1.toCharArray();
	    char[] ars2 = s2.toCharArray();
	    int count = 0;
	    Arrays.sort(ars1);
	    Arrays.sort(ars2);
	    for(int i = 0; i<s1.length(); i++){
	        for(int j = 0; j<s2.length(); j++){
	            if(ars1[i]==ars2[j]){
	                count++;
	                ars2[j]='0';
	                break;
	            }
	        }
	    }
	    
	    return count;
	}
	public static void main(String args[]){
		System.out.println(commonCharacterCount("aabcc","adcaa"));
	}

}
