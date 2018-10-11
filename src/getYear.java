package test;

public class getYear {
public int getYear1(int year)
{

	    int digits[] = new int[4];
	    int i=0;
	    
	    int temp = year;
	    
	    
	    
	    while(year > 0)
	    {
	        digits[i] = year%10;
	        year = year/10;
	        i++;
	    }
	    
	    if (i==1 || i==2) return 1;
	    if (i==3)
	    {
	        if (digits[0] > 0) 
	        	return temp/100 +1;
	        else return temp/100;
	    }
	    if (i==4)
	    {
	        if (digits[0] >0) return temp/100 +1;
	        else return temp/100;
	    }
	    return 0;
	    
	}

public static void main(String args[])
{
	getYear Y= new getYear();
	System.out.println(Y.getYear1(2000));
}

}
