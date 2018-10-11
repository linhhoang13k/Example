SumOfTwo{boolean sumOfTwo(int[] a, int[] b, int v) {
    HashSet<Integer> set = new HashSet<Integer>();
    for(int i = 0 ; i < a.length ; i++)
        set.add(a[i]);
    for(int i = 0 ; i < b.length ; i++){
        if(set.contains(v - b[i]))
            return true;
    }
    return false;
}
}
