int paintHouses(int[][] cost) {
    // do not change the array, make copies
    int[] prevResult = Arrays.copyOf(cost[0], cost[0].length);
    for (int i=1; i<cost.length; i++){
        int[] result = Arrays.copyOf(cost[i], cost[i].length);
        for (int j=0; j < result.length; j++){
            int min = Integer.MAX_VALUE;
            for (int k=0; k<3;k++){
                if (j != k){
                    min = Math.min(prevResult[k],min);
                }
            }
            result[j] += min;
        }
        prevResult = result;
    }
    
    return Math.min(prevResult[0], Math.min(prevResult[1], prevResult[2]));
}

