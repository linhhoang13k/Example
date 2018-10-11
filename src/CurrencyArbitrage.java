class CurrencyArbitrage {
    boolean currencyArbitrage(double[][] exchange) {
        double[][] dist = new double[exchange.length][exchange.length];
        for(int i = 0; i < exchange.length; i++) {
            for(int j = 0; j < exchange.length; j++) {
                dist[i][j] = Math.log(exchange[i][j]);
            }
        }
        int V = exchange.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] > dist[i][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i][i] > 0) {
                return true;
            }
        }
        return false;
    }
}