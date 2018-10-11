package Arcade_Intro;

public class _14_alternatingSums {
    int[] alternatingSums(int[] a) {
        int[] result = new int[]{0,0};
        for(int i = 0; i < a.length; i++){
            if(i %2 == 0) result[0] += a[i];
            else result[1] += a[i];
        }
        return result;
    }

    private int[] alternatingSumsShorter(int[] a) {
        int[] result = new int[2]; // Java initializes arrays with 0s.
        for(int i = 0; i<a.length; i++)
            result[i%2] += a[i];
        return result;
    }
}
