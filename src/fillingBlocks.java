/*
You have a block with the dimensions 4 × n. Find the number of different ways you can fill this block with smaller blocks that have the dimensions 1 × 2. You are allowed to rotate the smaller blocks.
*/
int fillingBlocks(int n) {
    int[] f = new int[n+5];
    f[0] = 0;
    f[1] = 1;
    f[2] = 5;
    f[3] = 11;
    f[4] = 36;
    for (int i = 5; i < n + 1; i++) {
        f[i] = f[i-1] + 5*f[i-2] + f[i-3] - f[i-4];
    }
    return f[n];
}
