package CodeFightsTasks;

/**
 * Created by Pasha on 24.01.2018.
 */
public class CFTask14 {
    int[] alternatingSums(int[] a) {
        int[] newArray = new int[2];
        newArray[0] = 0;
        newArray[1] = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0)
                newArray[0] += a[i];
            else
                newArray[1] += a[i];
        }
        return newArray;
    }
}
