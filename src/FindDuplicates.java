import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicates {

    public static int firstDuplicate(int[] a) {

        int[] possibleDuplicates = new int[a.length];
        possibleDuplicates[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            if (contains(possibleDuplicates, a[i])) return a[i];
            else possibleDuplicates[i] = a[i];
        }

        return -1;
    }

    public static int firstDuplicateAbs(int[] a) {

        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            temp = Math.abs(a[i]) - 1;

            if (a[temp] < 0) return Math.abs(a[i]);
            else a[temp] = -a[temp];
        }

        return -1;
    }

    public static int firstDuplicateHashSet(int[] a) {
        HashSet<Integer> possibleDuplicates = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if (possibleDuplicates.contains(a[i])) return a[i];
            else possibleDuplicates.add(a[i]);
        }

        return -1;
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}
