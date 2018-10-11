int makeArrayConsecutive2(int[] statues) {
        int counter = 0;
        Arrays.sort(statues);
        for(int i = 0; i < statues.length-1; i++){
            if((statues[i] + statues[i+1]) != (statues[i] + ((statues[i])+1))){
                counter += (statues[i+1] - statues[i] - 1);
            }
        }
        return counter;

}