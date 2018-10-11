import java.util.ArrayList;
import java.util.Iterator;


public class LongestIncreasingSubsequence {
	
	public static void main(String[] args)
	{
		int[] input = {96,25,14,22,19,88,7,73,47};
		
		System.out.print("Input:");
		for (int i = 0; i < input.length; i++) {
			
			System.out.print(" " + input[i]);
		}
		
		int[] output = longest_increasing_subsequence(input);
		
		System.out.print("\nOutput:");
		for (int i = 0; i < output.length; i++) {
			
			System.out.print(" " + output[i]);
		}
	}

	
	static int[] longest_increasing_subsequence(int[] input_array) {

		int[] dynamicProgrammingArray = new int[input_array.length];

		int currentMaxLength = 0;
		
		for (int i = 0; i < input_array.length; i++) {

			dynamicProgrammingArray[i]= 1;
			if(i==0)
			{
				
				currentMaxLength = 1;
				continue;
			}
			
			boolean lengthFound = false;
			
			for (int j = i-1; j >= 0; j--) {
				
				if(input_array[j]<input_array[i] && dynamicProgrammingArray[j]>=dynamicProgrammingArray[i])
				{
					lengthFound = true;
					dynamicProgrammingArray[i] = dynamicProgrammingArray[j] + 1;
					
					if(dynamicProgrammingArray[i] > currentMaxLength)
					{
						currentMaxLength = dynamicProgrammingArray[i];
					}
				}
			}
			
			if(!lengthFound)
			{
				dynamicProgrammingArray[i]= 1;
				if(dynamicProgrammingArray[i] > currentMaxLength)
				{
					currentMaxLength = dynamicProgrammingArray[i];
				}
			}
		}
		
		int[] output_array = new int[currentMaxLength];
		
		int i = currentMaxLength;
			
			for (int j = input_array.length -1; j >=0; j--) {
				
				if(dynamicProgrammingArray[j] == i)
				{
					output_array[i-1] = input_array[j];
					i--;
				}
				
			}
		
		return output_array;
	}
	
}
