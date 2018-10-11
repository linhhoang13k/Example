int makeArrayConsecutive2(int[] statues) {
    Arrays.sort(statues);
    int missingCount = 0;
    for(int i = 0; i < statues.length - 1; i++)
        if(statues[i] + 1 != statues[i + 1])
            missingCount += statues[i + 1] - statues[i] - 1;
    return missingCount;
}