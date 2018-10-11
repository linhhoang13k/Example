boolean isSmooth(int[] arr) {
    int middle = 0;
    if (arr.length%2 == 0) {
        middle = arr[arr.length/2 - 1] + arr[arr.length/2];
    }
    else {
        middle = arr[arr.length/2];
    }
    
    return arr[0] == arr[arr.length-1] && arr[0] == middle;
}
