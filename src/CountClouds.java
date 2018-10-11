int countClouds(char[][] skyMap) {
    
    int cloudCount = 0;

    for(int i = 0; i < skyMap.length; i++) {
        for(int j = 0; j < skyMap[0].length; j++) {
            if(skyMap[i][j] == '1') {
                cloudCount++;
                removeCloud(i,j,skyMap);
            }
        }
    }
    
    return cloudCount;
}

void removeCloud(int x, int y, char[][] skyMap) {
    skyMap[x][y] = '0';
    if(x-1 >= 0) {
        if(skyMap[x-1][y] == '1') {
            removeCloud(x-1,y,skyMap);
        }
    } 
    if(x+1 < skyMap.length) {
        if(skyMap[x+1][y] == '1') {
            removeCloud(x+1,y,skyMap);
        }
    }
    if(y-1 >= 0) {
        if(skyMap[x][y-1] == '1') {
            removeCloud(x,y-1,skyMap);
        }
    }
    if(y+1 < skyMap[0].length) {
        if(skyMap[x][y+1] == '1') {
            removeCloud(x,y+1,skyMap);
        }
    }
   
}
