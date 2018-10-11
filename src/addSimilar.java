boolean areSimilar(int[] a, int[] b) {
    
    if(a.length!=b.length) 
    {
        return false;
    }
    int swap[][]=new int[2][2];
    Map<Integer,Integer> m=new HashMap<>();
    int x=0;
    for(int i=0;i<a.length;i++)
    {
        if(x>2)
        {
            return false;
        }
        if(a[i]!=b[i])
        {
            if(x==0)
            {
            swap[x][x]=a[i];
            swap[x][x+1]=b[i];
        }
            else if(x==1)
            {
                swap[x][x-1]=a[i];
            swap[x][x]=b[i];

            }
            x++;
            
        }
        
    }
    if(x==2 || x==0)
    {
        if(x==0)
        {
            return true;
        }
        if(swap[0][0]==swap[1][1] && swap[0][1]==swap[1][0])
        {
            return true;
        }
    }
    
    return false;

}
