package arcade.corner01;

/**
 * Created by JavierSainz on 11/10/16.
 */
public class MirrorBits {

    int mirrorBits(int a) {
        int b = 0;
        while (a != 0) {
            b = b << 1 | (a & 1);
            a >>= 1;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new MirrorBits().mirrorBits(97));
    }
}
