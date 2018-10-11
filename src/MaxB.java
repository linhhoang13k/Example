package com.iub.coding.practice.CodeName47;

public class MaxB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = {8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116};
		
		//8 4 6 5 7.5 3 5.5 7 2.3 2.1 
		
		int maxArea = 0, height = 0, tempIndex = 0, j = 0;
		
		
		for(int i = 0; i < input.length; i++)	{
			
			height = input[i];
			
			for(j = i; j < input.length && input[j] >= input[i]; j++)	{
				
				//Do nothing
				
			}
			
			if(((height * (j - i)) > maxArea))
					maxArea = height * (j - i);
		}
		
		System.out.println(maxArea);
	}
	
	

}
