package test;
/*
 * You are given an array of integers representing
 *  coordinates of obstacles situated on a straight line.

Assume that you are jumping from the point with 
coordinate 0 to the right. You are allowed only to make jumps 
of the same length represented by some integer.

Find the minimal length of the jump enough to avoid all the obstacles.

Example

For inputArray = [5, 3, 6, 7, 9], the output should be
avoidObstacles(inputArray) = 4.

Check out the image below for better understanding:



Input/Output

[time limit] 3000ms (java)
[input] array.integer inputArray

Non-empty array of positive integers.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i] ≤ 40.

[output] integer

The desired length.


 */

public class avoidObstacles {
	
	int avoidObstacles(int[] inputArray) {

		for (int i =0;i<inputArray.length;i++)
		{
			for (int j=i+1;j<inputArray.length;j++)
			{
				if (inputArray[i] > inputArray[j])
				{
					int temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
					
				}
			}
		}
		
		int Jump = 1;
		int temp = Jump;
		boolean found= true;
		
    while(found){
		for (int i = 0 ;i<inputArray.length; i++)
		{
			if (inputArray[i]%Jump == 0 )
			{
				found = false;
				break;
			}
        }
           if (!found) 
           {
        	   found = true;
        	   Jump++;
        	   if (Jump == inputArray[inputArray.length-1]) return inputArray[inputArray.length-1]+1;
           }
        else return Jump;
        
		}
    
    return Jump;
    }
		





	
	
	public static void main(String args[])
	{
		int array[] = {5, 3, 6, 7, 9};
		avoidObstacles a =  new  avoidObstacles();
		System.out.println(a.avoidObstacles(array));
	}

}
