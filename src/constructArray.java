int[] constructArray(int size) {
    int [] result = new int [size];
    int x = size;
    for(int i = 0; i < size; i++) 
        result[i] = (i % 2 == 0)?(i + 2)/2:x--;
    return result;
}
