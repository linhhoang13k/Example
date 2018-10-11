String iqAddress(int n) {
    String r ="1";
    ArrayList<Double> a = new ArrayList<>();
    while(n>1)
    {
       a.add( (n%10.5));
       n =  (int)Math.ceil(n/2.0);
   }
    for(int i=a.size()-1; i>=0; i--)
    {
            r += String.valueOf(a.get(i));
    }
    return r;
}
