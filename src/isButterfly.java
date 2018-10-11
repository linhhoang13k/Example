boolean isButterfly(boolean[][] adj) {
    int countTwo = 0, countFour = 0, count = 0;
    for(int i = 0; i < 5; i++) {
        if(adj[i][i])
            return false;
        count = 0;
        for(int j = 0; j < 5; j++) {
            if(adj[i][j])
                count++;
        }
        if(count == 2)
            countTwo++;
        else if (count == 4)
            countFour++;
    }
    return countTwo == 4 && countFour == 1;
}
