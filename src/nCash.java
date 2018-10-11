int nCash(int[] m, int p) {
    // handle special case
    if (p == 0) return IntStream.of(m).anyMatch(x -> x == 0) ? 1 : 0;
    if (p == 1) return IntStream.of(m).anyMatch(x -> x == 1) ? 1 : 0;

    int[] minCoins = new int[p+1];

    // init values
    minCoins[0] = 0;
    int inf = (int)Math.pow(10, 9) + 7;
    for (int i = 1; i < p+1; i++) minCoins[i] = inf;

    // calculate the min number of papers to make each amount
    for (int i = 1; i < p+1; i++) {
        for (int amount: m) {
            if (amount <= i) {
                minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - amount]);
            }
        }
    }

    return minCoins[p];
}
