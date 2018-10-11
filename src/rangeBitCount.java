package arcade.corner01;

/**
 * Created by JavierSainz on 11/10/16.
 */
public class RangeBitCount {
    int rangeBitCount(int a, int b) {
        int totalBits = 0;
        for (; a <= b; a++) {
            int number = a;
            //totalBits += Integer.bitCount(a);
            while (number > 0) {
                number &= number - 1;
                totalBits++;
            }
        }
        return totalBits;
    }

    public static void main(String[] args) {
        System.out.println(new RangeBitCount().rangeBitCount(2, 7));
    }
}
