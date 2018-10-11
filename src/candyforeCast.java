/*

Every Christmas Mary's brother buys her a jar of candies, which naturally makes here very happy. Each year she counts the candies in the jar and writes down their number in her notebook, along with the current year.

The Christmas is coming, and Mary wants to know in advance how many candies she will get this time. She turns to you, her brother's best friend, for help. To get you started, Mary gave you the list of values where she has been writing all the information so far.

Your task is to study the list and try to determine how many candies Mary will get this year. You know that Mary's brother is very fond of statistics, so you want to approach the problem with the simple least squares linear regression model. Here's the result you should return:

the next year number;
the predicted number of candies Mary will get, rounded down to the nearest integer;
the trend in the number of candies that can be "increasing", "decreasing" or "stable'.
Example

For

values = [2012, 3, 2013, 4, 2014, 5, 2015, 6, 
          2016, 7, 2017, 8, 2018, 9, 2019, 10]
the output should be
candyForeCast(values) = ["2020", "11", "increasing"].

As you can see, each year Mary receives one more candy than the previous one. Thus, the trend is clearly "increasing", and in the next year of 2020 she will get 10 + 1 = 11 candies

*/

String[] candyForeCast(int[] values) {

    int[] xsquare = new int[values.length/2];
    int[] ysquare = new int[values.length/2];
    int[] xy      = new int[values.length/2];
    if(values.length<=4 || values==null)
    {
        return new String[]{};
    }
    if(values.length%2==1)
    {
        return new String[]{};
    }
    
    long Sx = 0;
    long Sy = 0;
    long Sxsquarre = 0;
    long Sysquarre =0;
    long Sxy =0;
    
    int c=0;
    for(int i=0; i<values.length; i+=2)
    {
        Sx += values[i];
        xsquare[c] = values[i]*values[i];
        Sxsquarre+=xsquare[c];
        c++;
    }
    c=0;
    for(int i=1; i<values.length; i+=2)
    {
        Sy += values[i];
        ysquare[c] = values[i]*values[i];
        Sysquarre += ysquare[c] ;
        c++;
    }
    
    c=0;
    for(int i=0; i<values.length-1; i+=2)
    {
        xy[c] = values[i]*values[i+1];
        Sxy += xy[c];
        c++;
    }
    
    double a= (double)((double)Sx*(double)Sy - (double)(values.length/2)*(double)Sxy) / ( (double)((double)Sx*(double)Sx) - (double)(values.length/2)*(double)Sxsquarre ) ;
    double b = ((double)Sx*(double)Sxy - (double)(Sy)*((double)Sxsquarre))/ (double)((double)Sx*(double)Sx - (double)(values.length/2)*(double)Sxsquarre    );
    
    System.out.println("a : "+a);
    System.out.println("b : "+b);
    
    double y = a*(values[values.length-2] +1) + b;
    System.out.println("Y is : " +(int)y);
    
   
   
    
    double mo = Sy/(values.length/2);
    
    System.out.println("MO is "+mo);
    
    String[] s = {"","",""};
    if(values.length<=4)
    {
        return s;
    }
    int max=0;
    for(int i=0; i<values.length; i+=2)
    {
        if(values[i]>=max)
        {
            max = values[i];
                
        }
    }
    
    int year = max +1;
    
    if(values[values.length-2] > values[values.length-4])
    {
        year = values[values.length-2]+1;
    }
    else
    {
        year = values[values.length-2]-1;
    }
    s[0] = Integer.toString(year);
    s[1] =Integer.toString((int)(y));
    if(y>mo)
    {
        s[2] = "increasing";
    }
    else if(y==mo || (y>= mo-20 && y<=mo+20))
    {
        s[2] = "stable";
    }
    else
    {
        s[2] = "decreasing";
    }
    
   
    return s;
}
