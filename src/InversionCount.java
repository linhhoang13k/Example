package interviewpractice.commonTechniquesAdvanced;

/**
 * @author benmakusha
 */
public class InversionCount {

    int countInversions(int[] a) {
        int inv_count = 0;
        int MOD = 1_000_000_007;
        int[] countLeft = new int[2001];
        for (int i = 0; i < a.length; i++){
            for (int j = a[i] + 1000 + 1; j <= 2000; j++){
                inv_count = (inv_count + countLeft[j]) % MOD;
            }
            countLeft[a[i] + 1000]++;
        }
        return inv_count;
    }
}
