int arrayChange(int[] inputArray) {
    int moves = 0;
    for (int x = 1; x < inputArray.length; x++)
    {
        while (inputArray[x] <= inputArray[x-1])
        {
            moves++;
            inputArray[x]++;
        }
    }
    return moves;
}
