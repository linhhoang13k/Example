package program.java.program;

import java.util.Scanner;

public class EvenPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();                 // Reading input from STDIN
        for(int i=0;i<testCase;i++){
        	 int[] hashTable = new int[10];
             int max = 0;
         	String number = scan.next();
        	String evenPalindrome = evenlength(number);
        	for(int k = 0;k < evenPalindrome.length(); k++){
        		char ch = evenPalindrome.charAt(k);
        		int n = Character.getNumericValue(ch);
        		hashTable[n]++;
        	}
        	
    		for(int l = 0; l<10; l++){
    			max = (max < hashTable[l]) ? hashTable[l] : max;
    		}
        	for(int l = 0; l<10; l++){
    					if(max == hashTable[l]){
    						System.out.println(l);
    	        			break;
    					}
    			
    		}
        	
        }
        
        scan.close();

        

	}
	static String evenlength(String n)
    {
        String res = n;
        for (int j = n.length() - 1; j >= 0; --j)
            res += n.charAt(j);
        return res;
    }

}
