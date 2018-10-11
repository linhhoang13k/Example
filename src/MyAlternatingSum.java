import java.util.Arrays;

/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 4
 * 
 * Several people are standing in a  row and need to be divided
 * into two teams. The first person goes into team 1, the 
 * second goes into team 2, the third goes into team 1 again, 
 * and so on.
 *  
 * You are given an array of positive integers - the weights of 
 * the people. Return an array of two integers, where the first
 * element is the total weight of team 1, and the second element
 * is the total weight of team 2 after the division is complete.
 * 
 */
public class MyAlternatingSum {
	
	public static int[] alternatingSums(int[] a) {

	    int team1 = 0;
	    int team2 = 0;
	    
	    for(int i = 0; i<a.length; i++){
	        if(i%2==0){
	            team1+=a[i];
	        }
	        else{
	            team2+=a[i];
	        }
	    }
	    
	    int[] teamWeight = {team1,team2};
	    
	    return teamWeight;
	}
	
	public static void main(String args[]){
		System.out.println(Arrays.toString(alternatingSums(new int[] {50,60,60,45,70})));
	}

}
