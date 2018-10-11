
boolean isLucky(int n) {

    String s = n+"";
    int sum = 0;
    
    for(int i=0; i<s.length()/2; i++)
        sum+=(s.charAt(i)-s.charAt(s.length()-1-i));
    
    return sum==0;
}
