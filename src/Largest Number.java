int largestNumber(int n) {
    return Integer.valueOf(String.join("", Collections.nCopies(n, "9")));
}
