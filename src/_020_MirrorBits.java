package Arcade_Core;

public class _020_MirrorBits {
    int mirrorBits(int a) {
        int newNumber = 0;
        while(a > 0){
            newNumber <<= 1;
            newNumber |= (a & 1);
            a >>= 1;
        }
        return newNumber;
    }
}
