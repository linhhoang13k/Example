package arcade.corner01;

/**
 * Created by JavierSainz on 11/10/16.
 */
public class SecondRightmostZeroBit {
    int secondRightmostZeroBit(int n) {
        //isolate the rightmost zero bit
        //y = ~x & (x+1)
        //apply the formula, set the rightmost bit and apply the formula again
        //int rightmost = ~n & (n + 1);
        //n = n | rightmost;
        //return (n + 1) & ~n;
        return (n = ~n & (n + 1) | n) + 1 & ~n;
    }

    public static void main(String[] args) {
        System.out.println(new SecondRightmostZeroBit().secondRightmostZeroBit(37));
    }
}
