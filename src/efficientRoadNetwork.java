boolean efficientRoadNetwork(int n, int[][] roads) {
    int inf = 99999;
    // build weight matrix
    int[][] w = new int[n][n];
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            w[r][c] = inf;
        }
    }
    for (int i = 0; i < n; i++) {
        w[i][i] = 0;
    }
    for (int[] road: roads) {
        w[road[0]][road[1]] = 1;
        w[road[1]][road[0]] = 1;
    }
    // floyd warshall
    for (int k = 0; k < n; k++) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                w[r][c] = Math.min(w[r][c], w[r][k] + w[k][c]);
            }
        }
    }
    // check if a shortest path between 2 nodes is > 2
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (w[r][c] > 2) return false;
        }
    }
    // ok
    return true;
}
