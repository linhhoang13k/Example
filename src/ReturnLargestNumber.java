package test;
/*Given an integer n, return the largest number that contains exactly n digits.

Example

For n = 2, the output should be
largestNumber(n) = 99.

Input/Output

[time limit] 3000ms (java)
[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 7.

[output] integer

The largest integer of length n.*/
public class ReturnLargestNumber {
	
	int largestNumber(int n) {
		
		String max = "";
		int i=0;
	    
		while (i < n){
			max = max+"9";
			i++;
		}
		return Integer.parseInt(max);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReturnLargestNumber str = new ReturnLargestNumber();
		System.out.println(str.largestNumber(8));

	}

}
