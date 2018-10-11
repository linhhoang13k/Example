int commonPoints(int l1, int r1, int l2, int r2) {
    int left = Math.max(l1, l2);
    int right = Math.min(r1, r2);
    return Math.max(right - left - 1, 0);
}
