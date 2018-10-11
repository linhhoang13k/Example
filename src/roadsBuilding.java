int[][] roadsBuilding(int cities, int[][] roads) {
    boolean[][] grid = new boolean[cities][cities];
    for (int[] road: roads) {
        grid[road[0]][road[1]] = true;
        grid[road[1]][road[0]] = true;
    }

    ArrayList<int[]> toBuild = new ArrayList<int[]>();
    for (int row = 0; row < cities; row++) {
        for (int col = row+1; col < cities; col++) {
            if (!grid[row][col]) {
                toBuild.add(new int[]{row, col});
            }
        }
    }
    return toBuild.toArray(new int[toBuild.size()][2]);
}
