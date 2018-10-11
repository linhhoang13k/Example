package Arcade_Core;

import java.util.stream.IntStream;

public class _030_appleBoxes {
    int appleBoxes(int k) {
        return IntStream.range(0,k+1).filter(n -> n % 2 == 0).map(n -> n * n).sum() -
                IntStream.range(0,k+1).filter(n -> n % 2 == 1).map(n -> n * n).sum();
    }
}
