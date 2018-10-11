package interviewpractice.geometry;

/**
 * @author benmakusha
 */
public class LazyCutter {

    int lazyCutter(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result += (i);
        }
        return result;
    }

}
