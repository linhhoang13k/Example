// https://codefights.com/challenge/uPYiZqNFE3n2LiLpg/solutions/jLXbt7xEgoE5jmNvN
int PeriodicRows(int n) {
    return n < 3 ? 1 : n < 11 ? 2 : n < 19 ? 3 : n < 37 ? 4 : n < 55 ? 5 : n < 86 ? 6 : 7;
}
