
public class PrimeSums2 {

	static int primesSum2(int n){
		int sum=0;
	    
	    for(int i=2;i<=n;i++)
	    {
	        int flag=0;
	        for(int j=2;j<i;j++)
	        {
	            if(i%j==0)
	                flag=1;
	        }
	        if(flag==0)
	        {
	            //System.out.print(i+" ");
	            sum=sum+i;
	        }
	    }
	    return sum;
	}
	public static void main(String[] args) {
		System.out.println(primesSum2(289384));
	}
}
