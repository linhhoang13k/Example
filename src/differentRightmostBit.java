package arcade.corner01;

/**
 * Created by JavierSainz on 11/12/16.
 */
public class DifferentRightmostBit {
    int differentRightmostBit(int n, int m) {
        //find different bits with XOR
        //and then find the first different isolating the rightmost 1 with y = x & (-x)
        return  (n = n ^ m) & -n;
    }

    public static void main(String[] args) {
        System.out.println(new DifferentRightmostBit().differentRightmostBit(12, 13));
    }
}
