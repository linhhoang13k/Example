class TreeDiameter {
    int treeDiameter(int n, int[][] tree) {
        if (n == 1) {
            return 0;
        }
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] node : tree) {
            adj[node[0]].add(node[1]);
            adj[node[1]].add(node[0]);
        }
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(tree[0][0]);
        int far = -1;
        while (!q.isEmpty()) {
            far = q.poll();
            vis[far] = true;
            for (int i : adj[far]) {
                if (!vis[i]) {
                    q.offer(i);
                }
            }
        }
        vis = new boolean[n + 1];
        q = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();
        depths.offer(0);
        q.offer(far);
        int depth = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            vis[node] = true;
            depth = depths.poll();
            for (int i : adj[node]) {
                if (!vis[i]) {
                    q.offer(i);
                    depths.offer(depth + 1);
                }
            }
        }
        return depth;
    }
}