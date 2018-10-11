boolean almostIncreasingSequence(int[] sequence) {
    int left =0;
    int right = sequence.length -1;
    
    while(left <right){
        if(sequence[left]>=sequence[left+1])
            break;
        left++;
    }
    
    if(left==right)
        return true;
    
    while(right>0){
        if(sequence[right-1]>=sequence[right])
            break;
        right--;
    }
    
    return left+1 == right && 
        ( right==sequence.length-1 
         || sequence[left] <sequence[right+1] 
         || left == 0 
         || sequence[left-1] < sequence[right]);
}