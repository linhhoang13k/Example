int countSumOfTwoRepresentations2(int n, int l, int r) {
    int count = 0;
    
    Set<Integer> set = new HashSet<>();
    
    for (int i=l;i<=r;i++) {
        set.add(i);
    }
    
    for (int num : set) {
        if (set.contains(n-num) && num <= n - num) {
            count++;
        }
    }
    
    return count;
}
