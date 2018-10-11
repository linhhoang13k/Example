// https://codefights.com/challenge/qKamuvBTdk5bZ8nPY/solutions/4smweFDC288xnyyGo
char TicTacToe(char[][] b) {
    if(b[0][0] == 'x' && b[0][1] == 'x' && b[0][2] == 'x'){
        return 'x';
    }
    if(b[1][0] == 'x' && b[1][1] == 'x' && b[1][2] == 'x'){
        return 'x';
    }
    if(b[2][0] == 'x' && b[2][1] == 'x' && b[2][2] == 'x'){
        return 'x';
    }
    if(b[0][0] == 'x' && b[1][1] == 'x' && b[2][2] == 'x'){
        return 'x';
    }
    if(b[2][0] == 'x' && b[1][1] == 'x' && b[0][2] == 'x'){
        return 'x';
    }
    if(b[0][0] == 'x' && b[1][0] == 'x' && b[2][0] == 'x'){
        return 'x';
    }
    if(b[0][1] == 'x' && b[1][1] == 'x' && b[2][1] == 'x'){
        return 'x';
    }
    if(b[0][2] == 'x' && b[1][2] == 'x' && b[2][2] == 'x'){
        return 'x';
    }
        if(b[0][0] == 'o' && b[0][1] == 'o' && b[0][2] == 'o'){
        return 'o';
    }
    if(b[1][0] == 'o' && b[1][1] == 'o' && b[1][2] == 'o'){
        return 'o';
    }
    if(b[2][0] == 'o' && b[2][1] == 'o' && b[2][2] == 'o'){
        return 'o';
    }
    if(b[0][0] == 'o' && b[1][1] == 'o' && b[2][2] == 'o'){
        return 'o';
    }
    if(b[2][0] == 'o' && b[1][1] == 'o' && b[0][2] == 'o'){
        return 'o';
    }
    if(b[0][0] == 'o' && b[1][0] == 'o' && b[2][0] == 'o'){
        return 'o';
    }
    if(b[0][1] == 'o' && b[1][1] == 'o' && b[2][1] == 'o'){
        return 'o';
    }
    if(b[0][2] == 'o' && b[1][2] == 'o' && b[2][2] == 'o'){
        return 'o';
    }
    return ' ';
}
