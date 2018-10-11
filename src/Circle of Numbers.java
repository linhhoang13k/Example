int circleOfNumbers(int n, int firstNumber) {
    int diff = (n-2)/2;
    if (firstNumber + diff + 1 < n) return firstNumber + diff + 1;
    
    return firstNumber - diff - 1;
}
