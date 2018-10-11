boolean almostIncreasingSequence(int[] sequence) {
    int jHolder = 0;
    boolean inc = false;
    boolean fourinc = false;
    ArrayList<Integer> first = new ArrayList<>();
    ArrayList<Integer> second = new ArrayList<>();
    int counter = 0;
    if(sequence.length == 4){
        for(int i = 0; i < sequence.length-1; i++){
            if(sequence[i] > sequence[i+1]){
                counter++;
            }
            if(sequence[i] < sequence[i+1]){
                if(sequence[sequence.length-2] >= sequence[sequence.length-1] && counter < 2){
                    fourinc = true;
                }
            }

        }
    }

    for(int i = 0; i < sequence.length/2; i++){
        first.add(sequence[i]);
    }

    for(int i = sequence.length/2; i < sequence.length; i++)
    {
        second.add(sequence[i]);
    }
    
    for(int i = 0; i < second.size(); i++){
        for(int j = jHolder; j < first.size(); j++){
            if(first.get(j) >= second.get(i)){
                counter++;
                break;
            }
            j++;
        }
        jHolder++;
    }
    
    int firstlargest = first.get(0);
    if(counter >= 1){
        for(int i = 1; i < first.size(); i++){

            if(first.get(i) == firstlargest){
                firstlargest = first.get(i);
                counter++;
            }
            if(counter == 1){
                break;
            }
        }
    }
    
    int largest = second.get(0);
    for(int i = 1; i < second.size(); i++){
        if(second.get(i) <= largest){
            counter++;
        }
        largest = second.get(i);
        
    }
    
    if(fourinc){
        counter--;
    }
    if(counter <= 2 && fourinc){
        inc = true;
    }else if (counter < 2){
        inc = true;
    }else{
        inc = false;
    }
    return inc;
}
