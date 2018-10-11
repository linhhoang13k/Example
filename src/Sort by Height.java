int[] sortByHeight(int[] a) {
    List<Integer> sortedHeights = new ArrayList<Integer>();
    for (int i = 0; i < a.length; i++) {
        if (a[i] != -1) {
            sortedHeights.add(a[i]);
        }
    }
    
    Collections.sort(sortedHeights);
    
    for (int i = 0; i < a.length; i++) {
        if (a[i] != -1) {
            a[i] = sortedHeights.get(0);
            sortedHeights.remove(0);
        }
    }
    
    return a;
}
