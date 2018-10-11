boolean[][] greatRenaming(boolean[][] roadRegister) {
    int len = roadRegister.length;
    boolean[][] res = new boolean[len][len];

    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
            res[(i+1)%len][(j+1)%len] = roadRegister[i][j];
        }
    }

    return res;
}
