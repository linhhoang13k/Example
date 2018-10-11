int computerNetwork(int n, int[][] network) {
    int[][] graph = new int[n][n];
    for(int i = 0; i < network.length; i++){
        int u = network[i][0] - 1;
        int v = network[i][1] - 1;
        int weight = network[i][2];
        
        graph[u][v] = graph[v][u] = weight;
    }
    
    return SPFA(n, graph);
}
private static int SPFA(int n , int[][] graph){
    int[] path = new int[n];
    for(int i = 0; i < path.length; i++){
        path[i] = Integer.MAX_VALUE/2;
    }
    path[0] = 0;
    
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    while(!q.isEmpty()){
        int newV = q.poll();
        for(int i = 0; i < graph.length; i++){
				if(graph[newV][i] != 0){
					if(path[i] > path[newV] + graph[newV][i]){
						path[i] = path[newV] + graph[newV][i];
						if(!q.contains(i))
							q.add(i);
					}
				}			
		}
    }
    return path[n-1];
}

