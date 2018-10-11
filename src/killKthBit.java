package arcade.corner01;

/**
 * Created by JavierSainz on 11/9/16.
 */
public class KillKthBit {
    int killKthBit(int n, int k) {
        //y = x & ~(1<<n)
        return n & ~(1 << k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new KillKthBit().killKthBit(37, 3));
    }
}
