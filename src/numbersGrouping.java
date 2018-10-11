int numbersGrouping(int[] a) {
    double x = 1e4 , y = 0 ;
    int sum = 0 , pos = 0;
    Arrays.sort(a);
    for(int i = 1 ; i <= 1e5 && pos < a.length ; i++){
        boolean f = true;
        ArrayList al = new ArrayList();
        while(f && pos < a.length){
            if(a[pos] > y && a[pos] <= i*x){
                al.add(a[pos]);
                pos++;
            }
            else{
                f = false;
            }
        }
        if(al.size() != 0)
            sum += al.size() + 1;
        y = i*x;
    }
    return sum;
}
