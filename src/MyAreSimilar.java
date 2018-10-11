/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 4
 * 
 * Two arrays are called similar if one can be obtained from another
 * by swapping at most one pair of elements. Given two arrays,
 * check whether they are similar.
 * 
 */
public class MyAreSimilar {

	public static boolean areSimilar(int[] A, int[] B) {

	    boolean flag = true;
	    int count = 0;
	    int temp = 0;
	    
	    //loop through array A
	    for(int i = 0; i<A.length; i++){
	    	//if not equal swap pairs that make them equal in array B and count swaps
	        if(A[i]!=B[i]){
	        	//loop through array B
	            for(int j = 0; j<B.length; j++){
	                if(A[i]==B[j]&&B[i]==A[j]){
	                    temp = A[i];
	                    B[j]=B[i];
	                    B[i] = temp;
	                }
	            }
	            count++;
	        }
	    }
	    
	    if(count>1){
	        flag = false;
	    }
	    
	    return flag;
	}
	
	public static void main(String args[]){
		System.out.println(areSimilar(new int[]{1,2,3}, new int[]{2,1,3}));
	}
}
