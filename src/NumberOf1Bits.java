class NumberOf1Bits {
    int numberOf1Bits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}