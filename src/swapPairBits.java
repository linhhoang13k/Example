public class swapPairBits {
    long swapPairBits(long k, int p1, int p2) {
        char[] result = String.format("%64s", Long.toBinaryString(k)).replace(' ', '0').toCharArray();
        p1 = 64 - p1;
        p2 = 64 - p2;
        char temp = result[p1];
        result[p1] = result[p2];
        result[p2] = temp;
        return Long.parseLong(new String(result), 2);
    }
}
