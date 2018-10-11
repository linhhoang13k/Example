int[] sortedSquaredArray(int[] array) {
    int [] result = new int[array.length];
    List <Integer> neg = new ArrayList<>(), pos = new ArrayList<>();
    for(int i = 0; i < array.length; i++) {
        if(array[i] < 0)
            neg.add(array[i] * array[i]);
        else
            pos.add(array[i] * array[i]);
    }
    int x = 0, y = neg.size() - 1, z = 0;
    while(x < array.length)
        result[x++] = y < 0?pos.get(z++):z == pos.size()?neg.get(y--):neg.get(y) < pos.get(z)?neg.get(y--):pos.get(z++);
    return result;
}
