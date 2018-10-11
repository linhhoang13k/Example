import java.util.Arrays;
/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 4
 * 
 * Given a rectangular matrix of characters, add a border 
 * of asterisks (*) to it.
 * 
 */
public class MyAddBorder {
	
	public static String[] addBorder(String[] picture) {

	    String[] newPicture = new String[picture.length+2];
	    String star = "";
	    for(int i = 1; i<picture.length+1; i++){
	        newPicture[i]="*"+picture[i-1]+"*";
	    }
	    for(int i = 0; i<picture[0].length()+2; i++){
	        star = star.concat("*");
	    }
	    newPicture[0]=star;
	    newPicture[picture.length+1]=star;
	    
	    return newPicture;
	}

	public static void main(String args[]){
		System.out.println(Arrays.toString(addBorder(new String[]{"abc","ded"})));
	}
}
