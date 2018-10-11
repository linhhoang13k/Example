/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 2
 * 
 * Given a sequence of integers as an array, determine whether
 * it is possible to obtain a strictly increasing sequence by removing
 * no more than one element from the array.
 * 
 */
public class MyAlmostIncreasingSequence {
	
	public static boolean almostIncreasingSequence(int[] sequence) {
	    boolean flag = true;
	    
	    int count = 0;
	    for(int i = 0; i<sequence.length-1; i++){
	        if(sequence[i]>=sequence[i+1]){
	            count++;
	        }
	         
	        if(count>1){
	            flag=false;
	            break;
	        }
	    }

	    return flag;
	}
	public static void main(String args[]){
		System.out.println(almostIncreasingSequence(new int[]{1,3,2,1}));
	}

}
