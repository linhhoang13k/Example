int[] amazonCheckmate(String king, String amazon) {
    int[] result = new int[4];
    Arrays.fill(result, 0);
    int[][] grid = new int[8][8];
    // 0 occupied
    // 2 amazon beats
    // 3 can occupy
    for (char i='1'; i<='8'; i++){
        for (char c='a'; c<='h';c++){
            String blackKing = new String(new char[]{c, i});
            if (closePositions(king, blackKing) ||
                blackKing.equals(amazon)){
                grid[i-'1'][c-'a'] = 0;
            }
            else if (shareRowCol(amazon, blackKing) ||
                     shareDiagonal(amazon, blackKing) ||
                     withinKnightsMove(amazon, blackKing)) {
                grid[i-'1'][c-'a'] = 2;
            } else {
                grid[i-'1'][c-'a'] = 3;
            }
        }
    }

    // if quees and king are on the same diag or row/col -
    // no check after king
    markKingBlocksAmazon(grid, king, amazon);
    // king can beat amazon, if the other king is not there
    markCanBeatAmazon(grid, king, amazon);
    
    for (int i=0; i<8; i++) {
        System.out.println(Arrays.toString(grid[i]));
        for (int j=0; j<8; j++){
            if (grid[i][j] == 2) {
                if (canMove(i,j,grid)){
                    // check
                    result[1]++;
                } else {
                    //checkmate
                    result[0]++;
                }
            } else if (grid[i][j] == 3){
                if (canMove(i,j,grid)){
                    // can move
                    result[3]++;
                } else {
                    // stalemate
                    result[2]++;
                }
            }
        }
    }

    return result;
}

boolean canMove(int k, int l, int[][] grid){
    if (k>0 && (grid[k-1][l] == 3 || grid[k-1][l] == 1) ||
        k<7 && (grid[k+1][l] == 3 || grid[k+1][l] == 1) ||
        l>0 && (grid[k][l-1] == 3 || grid[k][l-1] == 1)||
        l<7 && (grid[k][l+1] == 3 || grid[k][l+1] == 1) ||
        k>0 && l>0 && (grid[k-1][l-1] == 3 || grid[k-1][l-1] == 1) ||
        k<7 && l<7 && (grid[k+1][l+1] == 3 || grid[k+1][l+1] == 1) ||
        k>0 && l<7 && (grid[k-1][l+1] == 3 || grid[k-1][l+1] == 1) ||
        k<7 && l>0 && (grid[k+1][l-1] == 3 || grid[k+1][l-1] == 1))
        return true;
    //System.out.println(k + ":" + l);
    return false;
}

boolean shareRowCol(String fig1, String fig2) {
    return fig1.charAt(0) == fig2.charAt(0) ||
        fig1.charAt(1) == fig2.charAt(1);
}

boolean shareDiagonal(String fig1, String fig2) {
    return Math.abs(fig1.charAt(0) - fig2.charAt(0)) ==
        Math.abs(fig1.charAt(1) - fig2.charAt(1));
}

boolean withinKnightsMove(String amazon, String fig) {
    int l = Math.abs(amazon.charAt(0) - fig.charAt(0));
    int h = Math.abs(amazon.charAt(1) - fig.charAt(1));
    return l==1&&h==2 || l==2&&h==1;
}

boolean canBeatAmazon(String king, String amazon){
    if (Math.abs(king.charAt(0) - amazon.charAt(0)) > 1)
        return false;
    if (Math.abs(king.charAt(1) - amazon.charAt(1)) > 1)
        return false;
    return true;
}

boolean closePositions(String fig1, String fig2) {
    if (Math.abs(fig1.charAt(0) - fig2.charAt(0)) > 1)
        return false;
    if (Math.abs(fig1.charAt(1) - fig2.charAt(1)) > 1)
        return false;
    return true;
}

void markCanBeatAmazon(int[][] grid, String king, String amazon){
    if (!closePositions(king, amazon)){
        grid[amazon.charAt(1) - '1'][amazon.charAt(0) - 'a'] = 1;
    }
}

void markKingBlocksAmazon(int[][] grid, String king, String amazon){
    int distHoriz = king.charAt(0) - amazon.charAt(0);
    int distVert = king.charAt(1) - amazon.charAt(1);
    int king_l = king.charAt(0) - 'a';
    int king_n = Character.getNumericValue(king.charAt(1))-1;
    int amazon_l = amazon.charAt(0) - 'a';
    int amazon_n = Character.getNumericValue(amazon.charAt(1))-1;
    System.out.println("King: " + king_l + "-" + king_n +
                       "; Amazon: " + amazon_l + "-" + amazon_n);

    if (distHoriz == distVert) {
        // share diag
        if (king_l > amazon_l) {
            for (int i=king_n+2, j=king_l+2;i<8&j<8; i++,j++){
                grid[i][j] = 3;
            }
        } else {
            for (int i=king_n-2, j=king_l-2;i>=0&j>=0; i--,j--){
                grid[i][j] = 3;
            }
        }
    } else if (distHoriz == -distVert){
        if (king_l > amazon_l) {
            for (int i=king_n-2, j=king_l+2;i>=0&j<8; i--,j++){
                grid[i][j] = 3;
            }
        } else {
            for (int i=king_n+2, j=king_l-2;i<8&j>=0; i++,j--){
                grid[i][j] = 3;
            }
        }
    } else if (distHoriz == 0){
        //share column
        if (king_n > amazon_n){
            for (int i=king_n+2;i<8; i++){
                grid[i][king_l] = 3;
            }
        } else {
            for (int i=king_n-2;i>=0; i--){
                grid[i][king_l] = 3;
            }
        }
    } else if (distVert == 0) {
        // share row
        if (king_l > amazon_l){
            for (int i=king_l+2;i<8; i++){
                grid[king_n][i] = 3;
            }
        } else {
            for (int i=king_l-2;i>=0; i--){
                grid[king_n][i] = 3;
            }
        }
    }
}