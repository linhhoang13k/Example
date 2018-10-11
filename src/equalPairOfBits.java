package arcade.corner01;

/**
 * Created by JavierSainz on 11/12/16.
 */
public class EqualPairOfBits {
    int equalPairOfBits(int n, int m) {
        //XOR op to get equals numbers
        //then get rightmost 0 with y = ~x & (x+1)
        return ~(n = n ^ m) & (n + 1);
    }

    public static void main(String[] args) {
        System.out.println(new EqualPairOfBits().equalPairOfBits(10, 11));
    }
}
