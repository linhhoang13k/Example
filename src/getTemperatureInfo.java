int[] getTemperatureInfo(int[] measurements) {

    int[] a = new int[measurements.length];
    
    for(int i=0; i<measurements.length; i++)
    {
        if( i % 2 ==0 )
        {
            int x = 0;
            for(int j=0; j<i+1; j++)
            {
                 x += measurements[j];
                 a[i] = (int)Math.ceil((double)x/(i+1));
            }
        }
        if( i % 2 ==1 )
        {
            int x = 0;
            for(int j=0; j<i+1; j++)
            {
                 x += measurements[j];
                 a[i] = (int)Math.floor( ((double)x/(i+1)));
            }
        }
    }
    return a;
}
