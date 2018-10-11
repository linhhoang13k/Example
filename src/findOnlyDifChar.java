//first 

int findOnlyDiffChar(int[] a, int[] b) {

    
    ArrayList<Integer> arra = new ArrayList<>();
    ArrayList<Integer> arrb = new ArrayList<>();
    
    for(int i=0; i<a.length; i++)
    {
        arra.add(a[i]);
    }
     for(int i=0; i<b.length; i++)
    {
        arrb.add(b[i]);
    }
    
    for(int i=0; i<arrb.size(); i++)
    {
        
        for(int j=0; j<arrb.size()+1; j++)
        {
            if(arrb.get(i) == arra.get(j))
            {
                arrb.remove(i);
                arra.remove(j);
                i--;
                break;
            }
        }
    }
    
    return arra.get(0);
}


//second

int findOnlyDiffChar(int[] a, int[] b) {

  
    boolean x= false;
    for(int i=0; i<a.length; i++)
    {
        for(int j=0; j< b.length; j++)
        {
            if(a[i] != b[j])
            {
                x = false;
            }
            else
            {
                a[i] = -1;
                b[j] = -2;
                x = true;
                break;
            }
        }
        if(!x)
            return a[i];
    }
    return 0;
}
