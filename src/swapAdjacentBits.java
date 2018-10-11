package arcade.corner01;

/**
 * Created by JavierSainz on 11/12/16.
 */
public class SwapAdjacentBits {
    int swapAdjacentBits(int n) {
        //get just odd set bits, then move them to the left (even)
        //get even set bits and move them to the right (odd)
        //finally join numbers with |
        return (n & 0x55555555) << 1 | (n & 0xAAAAAAAA) >> 1;
    }

    public static void main(String[] args) {
        System.out.println(new SwapAdjacentBits().swapAdjacentBits(4));
    }
}
