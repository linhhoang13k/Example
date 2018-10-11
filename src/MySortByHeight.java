/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 3
 * 
 * Some people are standing in a row in a park. There are trees
 * between them which cannot be moved. Rearrange the people by 
 * their heights in a non-descending order without moving the trees.
 * 
 */
import java.util.Arrays;
import java.util.HashMap;

public class MySortByHeight {
	
	public static int[] sortByHeight(int[] a) {

	    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	    
	    //hashmap(index of -1, -1)
	    for(int i = 0; i < a.length; i++){
	        if(a[i]==-1){
	            hash.put(i,-1);
	        }
	    }
	    
	    //an array of only positive integers
	    int k  = 0;
	    int[] peopleArray = new int[a.length-hash.size()];
	    for(int j = 0; j<a.length; j++){
	        if(a[j]!=-1){
	            peopleArray[k]=a[j];
	            k++;
	        }
	    }
	    
	    Arrays.sort(peopleArray);
	    int[] outputArray = new int[a.length];
	    
	    //sorted array with -1's into an array
	    int s = 0;
	    for(int z=0; z<a.length; z++){
	        if(hash.containsKey(z)==true){
	            outputArray[z]=-1;
	        }
	        else{
	            outputArray[z]=peopleArray[s];
	            s++;
	        }
	    }
	    
	    return outputArray;
	}
	
	public static void main(String args[]){
		System.out.println(Arrays.toString(sortByHeight(new int[]{-1, 150, 190, 170, -1, -1, 160, 180})));
	}
}
