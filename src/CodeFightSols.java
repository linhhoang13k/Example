public class CodeFightSols {


    public static void main(String[] args) {
        //System.out.println(weakNumbers(5));
        int max = 0;
        int n = 1000;
        for (int i = 1; i < n; i++) {
            //int[] a = weakNumbers(i);
            //System.out.println("i: "  + i + "  Divisors:"  + countDivisors(i));
            max = Math.max(max, countDivisors(i));
        }
        System.out.println(max);
        System.out.println(Math.sqrt(n));
    }
    /**
     * We define the weakness of number x as the number of positive integers smaller than x that have more divisors than x.

     It follows that the weaker the number, the greater overall weakness it has. For the given integer n, you need to answer two questions:

     what is the weakness of the weakest numbers in the range [1, n]?
     how many numbers in the range [1, n] have this weakness?
     Return the answer as an array of two elements, where the first element is the answer to the first question, and the second element is the answer to the second question.

     Example

     For n = 9, the output should be
     weakNumbers(n) = [2, 2].

     Here are the number of divisors and the specific weakness of each number in range [1, 9]:

     1: d(1) = 1, weakness(1) = 0;
     2: d(2) = 2, weakness(2) = 0;
     3: d(3) = 2, weakness(3) = 0;
     4: d(4) = 3, weakness(4) = 0;
     5: d(5) = 2, weakness(5) = 1;
     6: d(6) = 4, weakness(6) = 0;
     7: d(7) = 2, weakness(7) = 2;
     8: d(8) = 4, weakness(8) = 0;
     9: d(9) = 3, weakness(9) = 2.
     As you can see, the maximal weakness is 2, and there are 2 numbers with that weakness level.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] integer n

     Guaranteed constraints:
     1 ≤ n ≤ 1000.

     [output] array.integer

     Array of two elements: the weakness of the weakest number, and the number of integers in range [1, n] with this weakness.
     */
    /**
     * found This puzzle particularly satisfying, expected input was <= 1000
     * The runtime if it were larger woould be similar to O(nlogn),
     * as the size of the largest possible divisor makes the counting sort
     * when x is 1,000,000 roughly 350.
     * @param n looking for weakest number related to n
     * @return
     */
    public static int[] weakNumbers(int n) {
        if (n <= 4) {
            int[] k = {0, n};
            return k;
        }
        int max = 0;
        int sum = 0;

        // This counter stores the max values for every weak number i
        // Radix was a bad name for the second array, however it helps
        // keep track of each number
        int[] counter = new int[n + 1];
        int[] radix = new int[50];
        // I suspect this can be optimized using prime numbers, reducing
        // the entire method to a O(n) time, but I found quickly
        // I did not have time to play with the math.
        for (int i = 1; i <= n; i++) {
            int temp = countDivisors(i);
            // note radix is more of a counting method, which is why it is a bad name
            radix[temp]++;
            for (int j = temp + 1; j < radix.length; j++) {
                sum += radix[j];
            }
            if (max <= sum) {
                max = sum;
                counter[i] = max;
            }
            sum = 0;
        }
        // run through the counter and find each.
        for (int i : counter) {
            if (i == max) {
                sum++;
            }
        }
        int[] sol = {max, sum};
        return sol;
    }

    /**
     * I did not write this, credit goes to @https://www.geeksforgeeks.org/count-divisors-n-on13/
     * @param n number to find divisors
     * @return number of divisors (must be greater than or equal to zero)
     */
    private static int countDivisors(int n)
    {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                if (n / i == i)
                    cnt++;
                else
                    cnt = cnt + 2;
            }
        }
        return cnt;
    }
}
