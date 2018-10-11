package com.iub.coding.practice.CodeName47;

public class ReplaceNumWithAvg {

	public static void main(String[] args) {

		StringBuffer buffer = new StringBuffer();

		int input = 654321; // 233416

		buffer.append(input);

		String max = null;

		// int strLen =
		
		//System.out.println(getMinReplacement(buffer));
		
		System.out.println(getSolution(input));

	}
	
	public static int getMinReplacement(StringBuffer buffer)	{
		
		int strLen = buffer.length();
		int prevMax = 0;
		
		int maxIndex = 0;
		
		maxIndex = getNextMaxIndex(buffer, strLen, prevMax);
		
		while(maxIndex < strLen - 1)	{
			
			prevMax = maxIndex;
			maxIndex = getNextMaxIndex(buffer, strLen, maxIndex + 1);
			
			if((maxIndex - prevMax) == 1 )	{
				
				return Integer.parseInt(buffer.deleteCharAt(maxIndex).toString());
			}
		}
		
		return Integer.parseInt(buffer.deleteCharAt(maxIndex - 1).toString());
	}

	public static int getNextMaxIndex(StringBuffer sb, int strLen, int startIndex) {

		int currentMax = sb.charAt(startIndex);
		int maxIndex = startIndex;

		for (int i = startIndex + 1; i < strLen; i++) {

			if (sb.charAt(i) > currentMax) {
				currentMax = sb.charAt(i);
				maxIndex = i;
			}

		}

		return maxIndex;
	}
	
	public static int getNextMinIndex(StringBuffer sb, int strLen, int startIndex) {

		int currentMax = sb.charAt(startIndex);
		int maxIndex = startIndex;

		for (int i = startIndex + 1; i < strLen; i++) {

			if (sb.charAt(i) > currentMax) {
				currentMax = sb.charAt(i);
				maxIndex = i;
			}

		}

		return maxIndex;
	}
	
	public static int getSolution(int number)	{
		
		String str =String.valueOf(number);
		int currentMax = 0;
		double k = 0.0;
		double j = 0.0;
		int md = 0;
		String val = null;
		int temp = 0;
		
		for(int i = 0; i < str.length() - 1; i++)	{
			k = Character.getNumericValue(str.charAt(i));
			j = Character.getNumericValue(str.charAt(i + 1));
			
			md = (int)Math.ceil((k + j)/2);
			
			val = str.substring(0, i) + Integer.toString(md) + str.substring(i+2);
			
			temp = Integer.valueOf(val);
			if(currentMax < temp)	{
				currentMax = temp;
			}
		}
		
		return currentMax;
	}
}
