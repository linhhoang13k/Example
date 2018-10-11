int[] graphDistances(int[][] g, int s) {
    int V = g.length;
    int[] dist = new int[V];
    boolean[] sptSet = new boolean[V];
    for(int i = 0; i < V; i++){
        dist[i] = Integer.MAX_VALUE;
    }
    dist[s] = 0;
    
    for(int count = 0; count < V - 1; count++) {
        int u = minDistIndx(dist, sptSet);
        
        sptSet[u] = true;
        
        for(int v = 0; v < V; v++) {
            if(!sptSet[v] 
               && g[u][v] != -1 
               && dist[u] != Integer.MAX_VALUE
               && dist[u] + g[u][v] < dist[v]) {
                dist[v] = dist[u] + g[u][v];
            }
        }
    }
    return dist;
}
int minDistIndx(int[] dist, boolean[] sptSet) {
    int min = Integer.MAX_VALUE;
    int min_indx = -1;
    int V = dist.length;
    for(int v = 0; v < V; v++) {
        if(sptSet[v] == false && dist[v] <= min) {
            min = dist[v];
            min_indx = v;
        }
    }
    return min_indx;
}
