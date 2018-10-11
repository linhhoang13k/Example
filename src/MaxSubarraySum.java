class MaxSubArraySum{
int arrayMaxConsecutiveSum2(int[] inputArray) {
    int max_so_far = 0;
    int sum = 0;
    
    int count = 0;
    int max = Integer.MIN_VALUE;
    for(int i = 0 ; i < inputArray.length ; i++){
        if(inputArray[i] < 0)
            count++;
        if(inputArray[i] > max)
            max = inputArray[i];
    }
    
    if(count == inputArray.length)
        return max;
    
    for(int i = 0 ; i < inputArray.length ; i++){
        sum += inputArray[i];
        if(sum > max_so_far)
            max_so_far = sum;
        if(sum < 0)
            sum = 0;
    }
    return max_so_far;
}
}
