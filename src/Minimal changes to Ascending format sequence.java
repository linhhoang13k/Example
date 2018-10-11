/*You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

Example

For inputArray = [1, 1, 1], the output should be
arrayChange(inputArray) = 3.*/

int arrayChange(int[] inputArray) {

    int c=0;
    for(int i=0; i<inputArray.length-1; i++)
    {
        if(inputArray[i]>= inputArray[i+1])
        {
            for(int j= inputArray[i+1]; j<= inputArray[i]; j++)
            {
                inputArray[i+1]++;
                c++;
            }
        }
    }
    return c;
}
