/*
	Given a divisor and a bound, find the largest integer N such that:

	    N is divisible by divisor.
	    N is less than or equal to bound.
	    N is greater than 0.

	It is guaranteed that such a number exists.

	Example

	For divisor = 3 and bound = 10, the output should be
	maxMultiple(divisor, bound) = 9.

	The largest integer divisible by 3 and not larger than 10 is 9.

	Input/Output

	    [time limit] 3000ms (java)

	    [input] integer divisor

	    Constraints:
	    2 ≤ divisor ≤ 10.

	    [input] integer bound

	    Constraints:
	    5 ≤ bound ≤ 100.

	    [output] integer

	    The largest integer not greater than bound that is divisible by divisor.

*/

// candies 문제를 거꾸로 한 것 뿐이다. 너무 쉽다.
int maxMultiple(int divisor, int bound) {
    return divisor * (bound / divisor);
}
