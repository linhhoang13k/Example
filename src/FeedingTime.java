class FeedingTime {
    int feedingTime(String[][] classes) {
        if (classes.length == 0) {
            return 0;
        }
        HashSet<String>[] set = new HashSet[classes.length];
        for (int i = 0; i < classes.length; i++) {
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < classes.length; i++) {
            for (String animal : classes[i]) {
                set[i].add(animal);
            }
        }
        ArrayList<Integer>[] adj = new ArrayList[classes.length];
        for (int i = 0; i < classes.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < classes.length; i++) {
            for (int j = 0; j < classes.length; j++) {
                if (i == j) {
                    continue;
                }
                for (String animal : classes[i]) {
                    if (set[j].contains(animal)) {
                        adj[i].add(j);
                    }
                }
            }
        }
        int[] colors = new int[classes.length];

        if (!isColorableGraph(0, 5, colors, adj)) {
            return -1;
        }
        int maxCol = 1;
        for (int i = 0; i < colors.length; i++) {
            maxCol = Math.max(maxCol, colors[i]);
        }
        return maxCol;
    }

    boolean isColorableGraph(int v, int m, int[] colors, ArrayList<Integer>[] adj) {
        if (v == colors.length) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c, colors, adj)) {
                colors[v] = c;
                if (isColorableGraph(v + 1, m, colors, adj)) {
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int v, int c, int[] colors, ArrayList<Integer>[] adj) {
        for (int j = 0; j < adj[v].size(); j++) {
            int adjacent = adj[v].get(j);
            if (c == colors[adjacent]) {
                return false;
            }
        }
        return true;
    }
}