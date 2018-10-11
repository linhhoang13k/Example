String FibonacciSecret(String m) {
    
    m = m.replaceAll("\\s+","");
    String s="";
    int F=1;
    for(int i = 0; i<m.length(); i+=F)
    {
        s+=m.charAt(i)+"-";
        F += i;
        if(F>m.length())
        {
            break;
        }
        s+=m.charAt(F)+"-";
    }
     s = s.substring(0, s.length()-1);
    return s.toUpperCase();
}
