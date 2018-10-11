/*
	Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between any two neighbouring numbers is equal (note that 0 and n - 1 are neighbouring, too).

Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.

Example

For n = 10 and firstNumber = 2, the output should be
circleOfNumbers(n, firstNumber) = 7.

Input/Output

    [time limit] 3000ms (java)

    [input] integer n

    A positive even integer.

    Constraints:
    4 ≤ n ≤ 20.

    [input] integer firstNumber

    Constraints:
    0 ≤ firstNumber ≤ n - 1.

    [output] integer

*/

// n으로는 짝수만 주어진다는 점, 거리를 사용한다는 점
// 그리고 다음 문장에 유의하라
// (note that 0 and n - 1 are neighbouring, too). 

// 환형 큐 만드는 법을 생각하면 쉽다.

int circleOfNumbers(int n, int firstNumber) {
    return (firstNumber +  n / 2) % n;
}
