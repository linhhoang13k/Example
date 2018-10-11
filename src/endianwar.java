boolean endianWar(String expression) {

    String num1= "";
    String num2= "";
    String num3= "";
    int indexison = 0;
    int indexsin = 0;
    for(int i=expression.length()-1; ; i--)
    {
        if(expression.charAt(i)=='=')
        {
            indexison=i;
            break;
        }
        num1+=expression.charAt(i);
    }
    
    for(int i=indexison-1; ; i--)
    {
        if(expression.charAt(i)=='+')
        {
            indexsin=i;
            break;
        }
        num2+=expression.charAt(i);
    }
    
    
    for(int i=indexsin-1; i>=0; i--)
    {
        
        num3+=expression.charAt(i);
    }
    
   
   
    return Integer.parseInt(num2)+Integer.parseInt(num3)==Integer.parseInt(num1);
}
