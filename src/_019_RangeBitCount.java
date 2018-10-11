package Arcade_Core;

import java.util.stream.IntStream;

public class _019_RangeBitCount {
    int rangeBitCount(int a, int b) {
        return IntStream.range(a,b+1).map(x -> Integer.bitCount(x)).sum();
    }
}
