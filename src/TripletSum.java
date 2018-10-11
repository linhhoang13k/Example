package InterviewPractice;

/**
 * Created by Trung on 5/20/2017.
 */
public class tripletSum {

    private static boolean contains(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) return true;
        }
        return false;
    }

    private static int max(int[] a, int limit) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i] && a[i] < limit - 1) max = a[i];
        }
        return max;
    }
    boolean tripletSum(int x, int[] a) {
        int count = 0;
        if (a.length >= 3) {
            boolean notDone = true;
            while (notDone) {
                int remainder = x - max(a, x);
                System.out.println("Max : " + max(a, x) + " Remainder: " + remainder);
                count++;
                while (count < 3) {

                    count++;
                }
                notDone = false;
            }

        }
        return false;
    }
}
