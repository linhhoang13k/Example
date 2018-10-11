/*
In chess, queens can move any number of squares vertically, horizontally, or diagonally. The n-queens puzzle is the problem of placing n queens on an n × n chessboard so that no two queens can attack each other.

Given an integer n, print all possible distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the placement of the n queens, where the solutions are arrays that contain permutations of [1, 2, 3, .. n]. The number in the ith position of the results array indicates that the ith column queen is placed in the row with that number. In your solution, the board configurations should be returned in lexicographical order.
*/

boolean isSafe(boolean board[][], int row, int col) {
    int n = board.length;
    // Check left to right
    for (int i = 0; i < n; i++) {
        if (board[row][i]) {
            return false;
        }
    }
    // Check top to bottom
    for (int i = 0; i < n; i++) {
        if (board[i][col]) {
            return false;
        }
    }

    // Check diagonal
    /*
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] && abs(i - row) == abs(j - col)) {
                return false;
            }
        }
    }
    */
    
    // Check upper diagonal on left side
    for (int i = row, j = col; i > -1 && j > -1; i--, j--) {
        if (board[i][j]) {
            return false;
        }
    }

    // Check bottom diagonal on left side
    for (int i = row, j = col; j > -1 && i < n; i++, j--) {
        if (board[i][j]) {
            return false;
        }
    }

    // Check upper diagonal on right side
    for (int i = row, j = col; i > -1 && j < n; i--, j++) {
        if (board[i][j]) {
            return false;
        }
    }

    // Check bottom diagonal on right side
    for (int i = row, j = col; j < n && i < n; i++, j++) {
        if (board[i][j]) {
            return false;
        }
    }

    return true;
}

int[][] nQueens(int n) {
    boolean[][] check = new boolean[n][n];
    int[][] result = new int[0][0];
    List<Integer[]> list = new ArrayList<Integer[]>();
    solveNQueen(check, list, 0);
    if (list.size() > 0) {
        result = new int[list.size()][n];
        for (int i = 0; i < list.size(); i++) {
            Integer[] arr = list.get(i);
            for (int j = 0; j < n; j++) {
                result[i][j] = arr[j];
            }
        }
    }
    return result;
}

void solveNQueen(boolean[][] check, List<Integer[]> list, int index) {
    int len = check.length;
    if (index == len) {
        Integer[] arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (check[i][j]) {
                    arr[i] = j + 1;
                    break;
                }
            }
        }
        list.add(arr);
    } else {
        for (int i = 0; i < len; i++) {
            if (isSafe(check, index, i)) {
                check[index][i] = true;
                solveNQueen(check, list, index + 1);
                check[index][i] = false;
            }
        }
    }

}