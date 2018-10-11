package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Use a binary search approach to pick two entries from an array of ints that add to a given value
 *
 * Note since the arrays passed in are not sorted, it is entirely unclear to me how to solve this with binary search
 * without first sorting the list, but that solves the O(n) max time constraint
 *
 * Full problem description:
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 *
 */
public class BinarySearchIceCream {

    static int[] getIndices(int money, int[] costs ) {

        // hashmap to store all possible ice-cream costs, as keys to their index in the array
        HashMap<Integer, Integer> costOptions = new HashMap<>();

        for (int i = 0; i < costs.length; i++) {
            int newCost = costs[i];
            // see if we've already found another ice-cream with a complementary match
            if (costOptions.containsKey(money - newCost)) {
                int[] solution = new int[2];
                solution[0] = Math.min(i + 1, costOptions.get(money - newCost));
                solution[1] = Math.max(i + 1, costOptions.get(money - newCost));
                return solution;
            } else {
                costOptions.put(costs[i], i + 1);
            }
        }
        // indicate an error and no solution found
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();           // read in the number of trials to be run
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();       // read in the amount of money
            int n = in.nextInt();       // read in the number of ice-cream flavours
            int a[] = new int[n];       // array to store the prices to buy each
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] solution = getIndices(m, a);
            System.out.println(solution[0] + " " + solution[1]);
        }
    }
}
