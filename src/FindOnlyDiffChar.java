package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jsainz on 29/01/17.
 */
public class FindOnlyDiffChar {
    int findOnlyDiffCharClean(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int length = b.length;
        for (int i = 0; i < length; i++) {
            if (a[i] != b[i]) {
                return a[i];
            }
        }
        return a[length];
    }
    int i, s;
    int findOnlyDiffChar(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (; i < b.length; i++)
            if (a[i] < b[i])
                break;
        return a[i];
    }

    int findOnlyDiffChar2(int[] a, int[] b) {
        return Arrays.stream(a).sum() - Arrays.stream(b).sum();
    }

    int findOnlyDiffChar3(int[] a, int[] b) {
        for (; i < b.length; )
            s += a[i] - b[i++];
        return a[i] + s;
    }

    int findOnlyDiffChar4(int[] a, int[] b) {
        for (int e : a)
            s += e;
        for (int e : b)
            s -= e;
        return  s;
    }

    //solution by CuongVM
    int j;
    int findOnlyDiffChar5(int[] a, int[] b) {
        for(int i : b) a[0] += a[++j] - i;
        return a[0];
    }


    public static void main(String[] args) {
        System.out.println(new FindOnlyDiffChar().findOnlyDiffChar3(
                new int[]{1, 2, 3, 4},
                new int[]{1, 3, 2}
        ));
    }
}
