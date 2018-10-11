package program.java.program;

import java.util.Arrays;
import java.util.Scanner;

public class DigitSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String size = scan.next();                 // Reading input from STDIN
        String[] array = new String[Integer.valueOf(size)];
        for(int i=0;i<array.length;i++){
        	array[i] = scan.next();
        }
        int[] hashTable = new int[10];
        int max = 0;
        for(int i=0;i<array.length;i++){
        	String number = array[i];
        	int[] dupArr = new int[10];
        	Arrays.fill(dupArr, 0);
        	for(int k = 0;k < number.length(); k++){
        		char ch = number.charAt(k);
        		int n = Character.getNumericValue(ch);
        		if(dupArr[n] == 0) hashTable[n]++;
        		dupArr[n]++;
        	}
        }
        for(int l = 0; l<10; l++){
			max = (max < hashTable[l]) ? hashTable[l] : max;
		}
    	for(int l = 0; l<10; l++){
					if(max == hashTable[l]){
						System.out.println(max);
	        			break;
		}
		}
        scan.close();
	}

}
