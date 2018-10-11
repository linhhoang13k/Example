public class candyCrush2 {
    boolean candyCrush2(char[][] gameboard, int[] cell, char direction) {
        int x = cell[0];
        int y = cell[1];

        switch (direction) {
            case 'U': gameboard = swap(gameboard, x, y, x-1, y);
            break;
            case 'D': gameboard = swap(gameboard, x, y, x+1, y);
            break;
            case 'R': gameboard = swap(gameboard, x, y, x, y+1);
            break;
            default: gameboard = swap(gameboard, x, y, x, y-1);
            break;
        }

        return checkRows(gameboard) || checkColumns(gameboard);
    }

    char[][] swap(char[][] gameboard, int initX, int initY, int finX, int finY) {
        char temp = gameboard[initX][initY];
        gameboard[initX][initY] = gameboard[finX][finY];
        gameboard[finX][finY] = temp;
        return gameboard;
    }

    boolean checkRows(char[][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            int j = 1;
            int counter = 0;
            while (j < gameboard[i].length) {
                if (gameboard[i][j-1] == gameboard[i][j]) {
                    counter++;
                    if (counter == 2) {
                        return true;
                    }
                }
                else {
                    counter = 0;
                }
                j++;
            }
        }
        return false;
    }

    boolean checkColumns(char[][] gameboard) {
        for (int i = 0; i < gameboard[0].length; i++) {
            int j = 1;
            int counter = 0;
            while (j < gameboard.length) {
                if (gameboard[j-1][i] == gameboard[j][i]) {
                    counter++;
                    if (counter == 2) {
                        return true;
                    }
                }
                else {
                    counter = 0;
                }
                j++;
            }
        }
        return false;
    }
}

