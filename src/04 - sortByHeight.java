int[] sortByHeight(int[] a) {
    ArrayList<Integer> people = new ArrayList<>();
        
    for(int i = 0; i < a.length; i++){
        if(a[i] > 0){
            people.add(a[i]);
        }
    }
    
    Collections.sort(people);
    
    for(int i = 0, j = 0; i < a.length; i++){
        if(a[i] > 0){
            a[i] = people.get(j);
            j++;
        }
    }
    return a;
}
