boolean almostIncreasingSequence(int[] sequence) {
    int count = 0;
    for (int i = 0; i < sequence.length - 1; i++) {
        if(sequence[i] >= sequence[i+1]){
            count++;
            if(i > 0){
                for(int j = i+2; j < sequence.length; j++){
                    if(sequence[i]>=sequence[j]
                       &&sequence[i-1]>=sequence[j-1]){
                        count++;
                    }
                }
            }
        }
    }
    if (count > 1) return false;
    else return true;
}