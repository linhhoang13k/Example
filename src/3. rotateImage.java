/*
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
*/

int[][] rotateImage(int[][] a) {
    for(int i = 0; i < a.length; i++){
        for(int j = i; j < a.length; j++){
            int temp = a[i][j];
            a[i][j] = a[j][i];
            a[j][i] = temp;
        }
    }
    
    for(int i = 0; i < a.length; i++){
        for(int j = 0; j < a.length/2; j++){
            int temp = a[i][j];
            a[i][j] = a[i][a.length-j-1];
            a[i][a.length-j-1] = temp;
        }
    }
    return a;
}
