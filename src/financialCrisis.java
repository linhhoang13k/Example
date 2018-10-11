boolean[][][] financialCrisis(boolean[][] roadRegister) {
    int length = roadRegister.length;
    boolean[][][] res = new boolean[length][length-1][length-1];

    for (int i = 0; i < length; i++) {
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                if (r != i && c != i) {
                    res[i][r > i ? r-1 : r][c > i ? c-1 : c] = roadRegister[r][c];
                }
            }
        }
    }

    return res;
}
