import java.math.BigInteger;

public class LattuceSolver {

    public static void main(String[] args) {
        BigInteger x = new BigInteger("10");
        System.out.println(factorial(1000));
        System.out.println(choose(4+7, 4));
        System.out.println(choose(2, 1));
        System.out.println(latticevillePaths(1000, 1000));
    }


    public static BigInteger choose(Integer n, Integer k) {
        if (n - k < 1 || k <= 0) return new BigInteger("1");
        BigInteger top = factorial(n);
        top = top.divide(factorial(k));
        top = top.divide(factorial(n - k));
        return top;
    }


    public static BigInteger factorial(Integer n) {
        if (n <= 1) return new BigInteger("1");
        BigInteger temp = new BigInteger(n.toString());
        while (n > 1) {
            n = n - 1;
            temp = temp.multiply(new BigInteger(n.toString()));
        }

        return  temp;
    }

    /**
     *  used @https://en.wikipedia.org/wiki/Narayana_number concepts to solve,
     *  found a paper and used the formula, along with some arithmetic to figure
     *  it out.
     * @param m
     * @param n
     * @return number of unique walks
     */
    static public BigInteger latticevillePaths(int m, int n) {
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        if (min < 3) {
            return new BigInteger("1");
        }
        int temp = 3;
        int temp2 = 0;
        while( temp < min) {
            temp += 1;
            temp2 += 1;
        }
        min = min - 2;
        max = max  + temp2;
        BigInteger first = choose(max,min);
        first = first.multiply(choose(max - 1, min));
        first = first.divide(new BigInteger(((Integer) (min + 1)).toString()));
        //Integer x = 1000000007;
        //first = first.mod(new BigInteger(x.toString()));
        return first;
    }
    /**
     * Esther and Daniel are playing a video game called Latticeville.
     * Each level in Latticeville consists of a grid of m by n rooms,
     * and the two players start in the southwest-most room. From each room in the level,
     * the players are only permitted to move north or east.
     * The level ends when both players reach the room furthest northeast.
     * Esther and Daniel want to maximize the amount of the game that they explore collectively,
     * so they want to ensure that—as much as possible—they never visit the same rooms as each other.
     * But there seem to be many different ways to accomplish this. Given the size of a level in Latticeville,
     * determine how many different subsets of rooms Esther and Daniel can visit such that the number of rooms visited is maximal.

     Since the answer may be quite large, return the result modulo 10^9 + 7.

     Examples

     For m = 3 and n = 3, the output should be latticevillePaths(3, 3) = 3.
     In this level, they can visit a maximum of 8 rooms, and there are three ways for them to do that.
     The three pairs of routes are depicted below. The rooms that are visited in each case are lightly shaded.
     3x3
     For m = 3 and n = 4, the output should be latticevillePaths(3, 4) = 6.
     They can visit a maximum of 10 rooms in this level, and there are six ways to do that, depicted below.
     3x4
     Input/Output

     [execution time limit] 3 seconds (java)

     [input] integer m

     The number of rows in the Latticeville level.

     Guaranteed constraints:
     1 ≤ m ≤ 10^3

     [input] integer n

     The number of columns in the Latticeville level.

     Guaranteed constraints:
     1 ≤ n ≤ 10^3

     [output] integer

     The number of ways to send the two players from the southwest room to the northeast room
     such that the number of rooms visited is maximal, modulo 109 + 7.
     */
}
