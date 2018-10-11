import java.util.Arrays;

/**
 Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.
 Given two arrays a and b, check whether they are similar.
 */
public class AreSimiliar {


    static boolean areSimiliar(int[] a, int[] b) {

        int[] array = new int[100];
        int index = 0;

        int pair = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                array[index] = a[i];
                array[index + 1] = b[i];
                index = index + 2;
                pair++;
            }
        }
        System.out.println(pair);


        if (Arrays.equals(a, b)) {
            return true;
        }

        if (array[0] == array[3] && array[1] == array[2] && pair == 2) {
            return true;
        } else  {
            return false;
        }
    }


    public static void main(String[] args) {

        int[] a = new int[]{832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
        int[] b = new int[]{832, 570, 148, 998, 533, 561, 455, 147, 894, 279};
        System.out.println(areSimiliar(a, b));
    }
}
