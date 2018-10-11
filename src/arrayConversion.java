int arrayConversion(int[] inputArray) {
    ArrayList al = new ArrayList();
    for(int i = 0 ; i < inputArray.length ; i++)
        al.add(inputArray[i]);
    int i = 1;
    while(al.size() != 1){
        ArrayList b = new ArrayList();
        if(i % 2 != 0){
            for(int j = 0 ; j < al.size()-1 ; j+=2)
                b.add((int)al.get(j) + (int)al.get(j+1));
        }
        else{
            for(int j = 0 ; j < al.size()-1 ; j+=2)
                b.add((int)al.get(j) * (int)al.get(j+1));
        }
        i++;
        al = b;
    }
    return (int)al.get(0);
}
