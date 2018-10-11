

public class RightTraingle {

	boolean rightTriangle(int[] s) {
	    int m=0,in=0;
	    for(int i=0;i<s.length;i++)
	    {
	        if(m<s[i])
	        {
	            m=s[i];
	            in=i;
	        }
	            
	    }
	    int x=0;
	    for(int i=0;i<3;i++)
	    {
	        if(i!=in)
	            x+=s[i]*s[i];
	    }
	return   x==(m*m);
	}

}
