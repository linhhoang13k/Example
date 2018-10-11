int arrayPacking(int[] a) {
 int result = 0, i = 0, shift = 0;
    while (i < a.length) {
    //Shifts for 8bits everytime a new number is added
        result += (a[i] << shift);
        shift += 8;
        i += 1;
    }
    return result;
}
