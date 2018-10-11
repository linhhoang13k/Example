int neighbouringElements(int[][] a) {
    int cnt = 0;
    for(int i = 0; i < a.length ; i++){
        for(int j = 0 ; j < a[i].length ; j++){
            if(i + 1 <a.length && a[i][j] == a[i+1][j]){ 
                cnt++;
            }
            if(j + 1 < a[i].length && a[i][j] == a[i][j+1]){
                cnt++;
            }
        }
    }
    return cnt;
}

/*
Find the number of unique pairs of neighboring elements with equal values in the given matrix.

Note neighboring : Two elements of a matrix are considered neighboring if their 
indices are equal on one axis and differ by one on the other axis.

a = [[1, 1, 1],
     [1, 1, 1],
     [1, 1, 1]]
the output should be neighbouringElements(a) = 12.
*/
