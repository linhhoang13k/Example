boolean namingRoads(int[][] roads) {
    // sort by road name
    Arrays.sort(roads, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int b[]) {
            return Integer.compare(a[2], b[2]);
        }
    });

    for (int i = 1; i < roads.length; i++) {
        if ((roads[i][0] == roads[i-1][0]) ||
            (roads[i][0] == roads[i-1][1]) ||
            (roads[i][1] == roads[i-1][0]) ||
            (roads[i][1] == roads[i-1][1])) {
            return false;
        }
    }

    return true;
}
