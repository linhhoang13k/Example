int arrayPacking(int[] a) {
    int result = 0;
    for(int index=0;index<a.length;index++) {
        result += a[index] << 8 * index;
    }
    
    return result;
}
