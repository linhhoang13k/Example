// https://codefights.com/challenge/mWJhr9v5gnarGPM6m/solutions/JEYxrxXTWefn8TohG
int[][] CountThePowers(int maxRoot, int N) {
    int[][] a = new int[maxRoot - 1][2];
    int b = 0;
    for(int i = 2; i <= maxRoot; i++) {
        for(int j = 1; Math.pow(j,i) <= N; j++) {
            a[b][0] = i;
            a[b][1] = j;
        }
        b++;
    }
    return a;
}
