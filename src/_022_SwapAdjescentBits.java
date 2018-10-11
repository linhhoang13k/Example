package Arcade_Core;

public class _022_SwapAdjescentBits {
    /**
     * abcdef
     * -> 0abcde -> 0a0c0e
     * -> bcdef0 -> b0d0f0
     * -------------------
     *              badcfe
     */

    int swapAdjacentBits(int n) {
        return (((n>>1)&0b01010101010101010101010101010101) +
                ((n<<1)&0b10101010101010101010101010101010));
    }
}
