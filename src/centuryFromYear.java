
public class CenturyFromYear 
{
	public static void main(String [] args)
	{
		int centuryFromYear(int year) 
		{
		    //Divide year by 100 using integer division.
		    //Add 1.
		    //Test case: 1/100 = 0+1 = 1, 1905/100 = 19 + 1 = 20
		    
		    //This doesn't work if the year is evenly divided by 100.
		    //In that case the century is just the quotient of year 
		    //divided by 100. 
		     
		    int century;
		    
		    if(year % 100 == 0)
		    {
		        century = year / 100;
		    }    
		    else
		    {
		        century = (year / 100) + 1;
		    }    
		    return century;
		}
	}
}
