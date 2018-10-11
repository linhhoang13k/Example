
public class CheckPalindrome
{	
	boolean checkPalindrome(String inputString) 
	{
	    boolean flag = true;
	    for(int i = 0; i < inputString.length()/2; i++)
		{	    	
		    if (inputString.charAt(i) != inputString.charAt(inputString.length() - i - 1)) 
	        {
	            return false;
	        }
	    }
	    return flag;
	}
}