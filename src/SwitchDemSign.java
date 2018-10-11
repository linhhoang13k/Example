String switchDemSigns(String linEq) {

    String s="";
    int brackets1=0;
    int brackets2 =0;
    for(int i=0; i<linEq.length(); i++)
    {
        if(i==0 &&linEq.charAt(i) == '-')
        {
            s+="+";
            continue;
        }
        else if(i==0 && linEq.charAt(i)!='-')
        {
            s += "- ";
        }
        if(linEq.charAt(i)=='(' || linEq.charAt(i)=='{' || linEq.charAt(i)=='[')
        {
            brackets1++;
        }
        if(linEq.charAt(i)==')' || linEq.charAt(i)=='}' || linEq.charAt(i)==']')
        {
            brackets2++;
        }
        if(brackets1!=brackets2)
        {
             s+=linEq.charAt(i);
        }
        else
        {
            if(linEq.charAt(i) == '-')
            {
                s+="+";
            }
            else if(linEq.charAt(i) == '+')
            {
                s+="-";
            }
            else
            {
                s+=linEq.charAt(i);
            }
        }
       
    }
    return s;
}
