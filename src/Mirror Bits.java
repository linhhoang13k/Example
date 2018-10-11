int mirrorBits(int a) {
    StringBuilder sb = new StringBuilder(Integer.toBinaryString(a));
    return Integer.parseInt(sb.reverse().toString(), 2);
}
