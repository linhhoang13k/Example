package javaFights.isPowerOfTwo2;

/**
 Determine whether the given number n is a power of two.

 Example

 For n = 64, the output should be
 isPowerOfTwo2(n) = true;

 For n = 5, the output should be
 isPowerOfTwo2(n) = false.

 Input/Output

 [time limit] 3000ms (java)
 [input] integer64 n

 A positive integer.

 Constraints:
 1 ≤ n ≤ 1012.

 [output] boolean

 true if n can be represented in the form 2b (2 to the power of b) where b is a non-negative integer; false otherwise.
 */
public class IsPowerOfTwo2 {
    public static boolean isPowerOfTwo(long n) {
        return ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        long n = 64;
        System.out.println(isPowerOfTwo(n));
    }
}
