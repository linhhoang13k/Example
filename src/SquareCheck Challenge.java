/*
You are given 4 points on a Cartesian plane. Return true if these points form a square, and false otherwise.

Example

For

points = [0, 0, 
          0, 3,
          3, 3, 
          3, 0]
the output should be
Square_Check(points) = true.
*/


boolean Square_Check(int[] points) {


   
    ArrayList<Double> arr = new ArrayList<>();
    for(int i=2; i<points.length-1; i+=2)
    {
        double distance = (double)Math.sqrt( (points[i]-points[0])*(points[i]-points[0]) + (points[i+1]-points[1])*(points[i+1]-points[1]) );
        if(!arr.contains(distance))
        {
            arr.add(distance);
        }
    }
    

    if(arr.size()==2)
        return true;

    
    
    
        return false;
    

}



//shorter


boolean Square_Check(int[] p) {


   
    ArrayList<Double> a = new ArrayList<>();
    for(int i=2; i<p.length-1; i+=2)
    {
        double d = Math.sqrt(Math.pow(p[i]-p[0],2)+Math.pow(p[i+1]-p[1],2));
        if(!a.contains(d))
            a.add(d);
    }
    

    if(a.size()==2)
        return true;


        return false;

}

//shortest but misunderstadable

    for(int i=2; i<p.length-1; i+=2)
    {
        d = Math.sqrt(Math.pow(p[i]-p[0],2)+Math.pow(p[i+1]-p[1],2));
        if(d!=x && y==0)
            x=d;
        if(d!=y && x!=0)
            y=d;
        if(d!=x && d!=y)
            return false;
       
    }
    

        return true;
}