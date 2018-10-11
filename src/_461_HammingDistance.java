package Easy;

/**
 * Created by Trung on 10/14/2017.
 *
 * Problem statement: The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different. Given two integers x and y, calculate the Hamming distance.
 * 0 < x, y < 2^31
 *
 * Solution: Find the difference between the numbers by XOR. Check every bit of the result when AND with mask 0x1
 * (0x1 is used to check only the least significant bit)
 */
public class _461_HammingDistance {

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            if ((n & 0x1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
