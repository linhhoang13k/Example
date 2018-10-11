package codefights.arcade;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapPhonebook  {

	//adjust the given names to appropriate numbers

		public static void main(String[] args) {
		
			Scanner scan = new Scanner (System.in);
			int n = scan.nextInt();
			Map<String,Integer> phoneBook = new HashMap<String,Integer>();
			
			 for (int i=0; i<n; i++) {
				 String name = scan.next(); //key
				 int  phone = scan.nextInt(); //value
		
				 phoneBook.put(name, phone);
				 
			 }
		 
			while (scan.hasNext()) {
				
				String s = scan.next();
				Integer phoneNumber = phoneBook.get(s);
				
				System.out.println((phoneNumber != null)  ? s + "=" + phoneNumber  : "Not found");
		               
		
	        }
			scan.close();
	    }
}


	
	
	
	
