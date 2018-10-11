int firstDuplicate(int[] a) {
    Set<Integer> set = new HashSet<>();
    int tempIndex = 0;
    int length = a.length;
    int result = 0;
    for (int i = 0; i < length; i++) {
        if (!set.add(a[i])) {
            tempIndex = i;
            if (tempIndex <= i) {
                result = a[i];
                break;
            }
        } else {
            result = -1;
        }
    }
    return result;
}
