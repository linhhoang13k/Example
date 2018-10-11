package test;
/*
 * Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

Example

For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false;

There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
almostIncreasingSequence(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
 */

public class StriclyIncreasing {

	boolean almostIncreasingSequence(int[] sequence) {

		
		boolean shift = false;

		for (int i=0;i<sequence.length;i++)
			
		{
			if (shift && i < sequence.length-1)
			{
				sequence[i] = sequence[i+1];
			}
				
			else if (i < sequence.length-1 && sequence[i] >= sequence[i+1] )
			{
				if (i==0)
				sequence[i] = sequence[i+1];
				else
				{
					if (sequence[i-1] < sequence[i+1])
					{
						sequence[i] = sequence[i+1];
					}
				}
				shift = true;
			}
		}
		
		if (!shift) return true;
		else
			{
			for (int i=0 ; i<sequence.length-1;i++)
		{
			if (i< sequence.length-2)
				{
				System.out.println(sequence[i] + " "+ sequence[i+1]);
				if(sequence[i] >= sequence[i+1])return false;
				}
				
		}}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StriclyIncreasing s = new StriclyIncreasing();
		int[] seq = { 1, 2, 1, 2};
		System.out.println(s.almostIncreasingSequence(seq));

	}

}
