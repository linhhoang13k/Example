import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus{

    public static String plusMinus(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }

        int pos = 0, negs = 0, zeroes = 0, total = arr.length;

        for (int a : arr) {
            if (a > 0) {
                pos++;
            } else if (a == 0) {
                zeroes++;
            } else {
                negs++;
            }
        }

        return ((double) pos / total + "\n" + (double) negs / total + "\n" + (double) zeroes / total);
    }
}
