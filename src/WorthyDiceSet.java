package in.mkp.challenges;

import java.util.Arrays;

/**
 * https://codefights.com/challenge/5vrZzsJ6L8Y5CXdKm
 */
public class WorthyDiceSet {

    public static void main(String[] args) {
        WorthyDiceSet worthyDiceSet = new WorthyDiceSet();
        System.out.println("worthyDiceSet.worthyDiceSet(2, 5) = " + worthyDiceSet.worthyDiceSet(2, 5));
    }

    int m;
    int tot;
    int worthyDiceSet(int n, int mod) {
        m = mod;
        int[] a = new int[n];
        get(0, n, a);
        return tot;
    }

    void get(int i, int n, int[] a) {
        // Base Case
        if (i == n) {
            int sum = 0;
            int prod = 1;
            for (int j=0; j < n; ++j) {
                sum+=a[j];
                prod*=a[j];
            }
            if ((sum % m) == (prod % m))  {
                tot++;
                System.out.println(Arrays.toString(a));
            }
            return ;
        }
        //Recursively build the input
        for (int j=1; j <= 6; ++j) {
            a[i] = j;
            get(i+1, n, a);
        }
    }

}
