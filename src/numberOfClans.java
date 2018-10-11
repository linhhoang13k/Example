int numberOfClans(int[] divisors, int k) {
    List<ArrayList> l = new ArrayList();
    ArrayList al = new ArrayList();
    for(int i = 1 ; i <= k ; i++){
        if(al.contains(i))
            continue;
        al.add(i);
        ArrayList x = new ArrayList();
        x.add(i);
        for(int j = 1 ; j <= k ; j++){
            if(i == j)
                continue;
            int f = 0;
            for(int p = 0 ; p < divisors.length ; p++){
                if((i % divisors[p] == 0 && j % divisors[p] != 0) 
                   || (i % divisors[p] != 0 && j % divisors[p] == 0)){
                    f = 1;
                    break;
                }
            }
            if(f == 0){
                x.add(j);
                al.add(j);
            }
        }
        l.add(x);
    }
    return l.size();
}
