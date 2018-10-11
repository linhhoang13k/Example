int rangeBitCount(int a, int b) {
    int count = 0;
    while (a <= b) {
        count += Integer.bitCount(a);
        a++;
    }
    
    return count;
}
