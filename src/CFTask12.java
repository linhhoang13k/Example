package CodeFightsTasks;

/**
 * Created by Pasha on 23.01.2018.
 */
public class CFTask12 {
    int[] sortByHeight(int[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = i; j < a.length; j++) {
                if (a[i] == -1)
                    break;
                if (a[j] == -1)
                    continue;
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        return a;
    }

}
