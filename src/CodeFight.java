import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Greta
 * 
 * This program should give the String representation of integers, replacing multiples of 5 with
 * "Code", multiples of 7 with "Fight", and multiples of both with "CodeFight".
 * 
 */
public class CodeFight {

	static HashMap<Integer, String> hm = new HashMap<Integer, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int maxNum = 0;
		Scanner input = new Scanner(System.in);
		
		//Get the user to enter the maxmimum number that must be greater than 1
		
		while(maxNum <= 0 || maxNum > 9999){
			System.out.println("Please enter a whole number greater than 1 and less than 10000.");
			try{
				maxNum = Integer.parseInt(input.nextLine());
			}catch(Exception e){
				System.out.println("That was not a valid whole number greater than 1 and less than 10000.");
				maxNum = 0;
				System.out.println("");
			}
		}
		
		//Load the Hashmap with numbers 0-9 as keys, and the String equivalents as values.
		
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");
		hm.put(10, "ten");
		hm.put(11, "eleven");
		hm.put(12, "twelve");
		hm.put(13, "thirteen");
		hm.put(14, "fourteen");
		hm.put(15, "fifthteen");
		hm.put(16, "sixteen");
		hm.put(17, "seventeen");
		hm.put(18, "eighteen");
		hm.put(19, "nineteen");
		hm.put(20, "twenty");
		hm.put(30, "thirty");
		hm.put(40, "fourty");
		hm.put(50, "fifty");
		hm.put(60, "sixty");
		hm.put(70, "seventy");
		hm.put(80, "eighty");
		hm.put(90, "ninety");
		
		for(int i = 1; i <= maxNum; i++){
			StringBuilder sb = new StringBuilder("");
			
			int tempNum = i;
			
			if(tempNum % 5 == 0 && tempNum % 7 == 0)
				sb.append("CodeFight");
			else if(tempNum % 5 == 0)
				sb.append("Code");
			else if(tempNum % 7 == 0)
				sb.append("Fight");
			else{
				
				if(tempNum >= 1000){
					int thousands = tempNum / 1000;
					tempNum %= 1000;
					sb.append(getString(thousands));
					sb.append(" thousand, ");
				}
				
				if(tempNum >= 1000){
					int thousands = tempNum / 1000;
					tempNum %= 1000;
					sb.append(getString(thousands));
					sb.append(" thousand, ");
				}
				
				if(tempNum >= 100){
					int hundreds = tempNum / 100;
					tempNum %= 100;
					sb.append(getString(hundreds));
					sb.append(" hundred ");
				}
				
				if(tempNum >= 20){
					int tens = tempNum / 10;
					tens *= 10;
					tempNum %= 10;
					sb.append(getString(tens));
					sb.append(" ");
				}
				
				if(tempNum >= 1){
					sb.append(getString(tempNum));
				}
				
			}
			
			System.out.println(sb.toString());
			
		}
		
		input.close();

	}
	
	
	private static String getString(int numToConvert){
		String converted = "";
		converted = hm.get(numToConvert);
		return converted;
	}

}
