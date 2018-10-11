package Arcade_Core;

import java.util.stream.IntStream;

public class _002_LatgestNumber {
    int largestNumber(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n).forEach(x -> {sb.append('9');});
        return Integer.parseInt(sb.toString());
    }

    /*Even better*/
    int largestNumber2(int n) {
        return (int)Math.pow(10, n) - 1;
    }

}
