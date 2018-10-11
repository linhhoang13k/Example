/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 3
 * 
 * Given an array of strings, return another array containing
 * all of its longest strings.
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;

public class MyAllLongestString {

	public static String[] allLongestStrings(String[] inputArray) {
	    
	    int longest = inputArray[0].length();
	    ArrayList<String> list = new ArrayList<String>();
	    
	    //find the longest string 
	    for(int i = 0; i<inputArray.length; i++){
	        int temp = inputArray[i].length();
	        if(longest<temp){
	            longest = temp;
	        }
	    }
	    
	    //creates arraylist with any string that equals longest
	    for(int i = 0; i<inputArray.length; i++){
	        if(longest==inputArray[i].length()){
	            list.add(inputArray[i]);
	        }
	    }
	    
	    String[] a = list.toArray(new String[0]);
	    return a;
	}

	public static void main(String args[]){
		System.out.println(Arrays.toString(allLongestStrings(new String[]{"aba","ad","vcd","aba"})));
	}
}
