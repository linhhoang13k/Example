/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 2
 * 
 * Given an array of positive integers, figure out the minimum 
 * number of additional statues needed that will arrange the array
 * from smallest to largest so that each integer will be bigger than
 * previous by exactly 1.
 * 
 */
import java.util.Arrays;

public class MyMakeArrayConsecutive2 {
	
	public static int makeArrayConsecutive2(int[] statues) {

	    Arrays.sort(statues);
	    
	    int math = 0;
	    int count = 0;
	    for(int i = 0; i<statues.length-1; i++){
	        math = statues[i+1]-statues[i];
	        if(math!=1){
	            count=count+math-1;
	        }
	    }
	    return count;
	}
	
	public static void main(String args[]){
		System.out.println(makeArrayConsecutive2(new int[]{6,3,2,8}));
	}
}
