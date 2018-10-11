int houseNumbersSum(int[] inputArray) {
    int s = 0;
    for(int i = 0 ; inputArray[i] != 0 ; i++)
        s += inputArray[i];
    return s;
}
