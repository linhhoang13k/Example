boolean checkIncreasingSequence(int[] seq) {

    for(int i=0;i<seq.length-1;i++)
    {
        if(seq[i+1]<=seq[i])
            return false;
    }
    return true;
}
