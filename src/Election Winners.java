int electionsWinners(int[] votes, int k) {
    int maxCount = 0;
    for (int i=0;i<votes.length;i++) {
        if (isMax(votes, votes[i]+k, i)) {
            maxCount++;
        }
    }
    
    return maxCount;
}

boolean isMax(int[] arr, int num, int id) {
    for(int i=0;i<arr.length;i++) {
        if(arr[i] >= num && i != id) {
            return false;
        }
    }
    
    return true;
}
