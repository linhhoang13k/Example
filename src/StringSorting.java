import java.awt.event.TextEvent;
import java.awt.print.Printable;

import acm.program.ConsoleProgram;
import acmx.export.java.util.Scanner;

public class StringSorting extends ConsoleProgram
{
		
		public static void main(String[] args) 
		{
		    		Scanner scanner = new Scanner(System.in);
					String[] entriesOfString;
					//System.out.println(" \n Enter length of string");
					//lengthOfOneString = scanner.nextInt();
					 
 					entriesOfString = new String[]{"aba", 
 							 "bbb", 
 							 "bab"

};
					
 					System.out.println(stringsRearrangement(entriesOfString));
							
		}

		private static boolean stringsRearrangement(String[] inputArray)
		{
					int count1;
					count1= arrangeString(inputArray);
					if(count1 != inputArray.length -1)
					{
						for (int i = 0; i < inputArray.length -1; i++)
						{
								swapMethod(inputArray, i, i+1);	
								count1 = arrangeString(inputArray);
						}
					}
					if(count1 == inputArray.length -1) 
					{
							return true;
					}
					else
					{
						return false;
					}
			
		}

		public static int arrangeString(String[] entriesOfString) {
			int countToReturn=0;
			for (int i = 0; i < entriesOfString.length; i++) 
			{
					String temp1 = entriesOfString[i];
					for (int j = i+1 ; j < entriesOfString.length; j++) 
					{
						int count = 0;
							String temp2 = entriesOfString[j];
							for (int k = 0; k < temp1.length(); k++) 
							{
									if (temp1.charAt(k) == (temp2.charAt(k))) 
									{
										
									}
									else
									{
										count++;	
									}
							}
							if (count == 1 ) 
							{
									swapMethod(entriesOfString, i+1, j);	
									countToReturn++;
									break;
							}
							
					}			
			}
			return countToReturn;
		}

		public static void swapMethod(String[] entriesOfString, int i, int j) {
			String temp = entriesOfString[j];
			entriesOfString[j] = entriesOfString[i];
			entriesOfString[i] =temp;
		}	

}
