
public class AddingBorders 
{
	public static void main(String v[])
	{
		System.out.println(-10/-3);
		String[] input = {"abcde","fghij"};
		String[] result = addBorder(input); 
		for(int i=0; i<result.length;i++)
		{
			System.out.println(result[i]);
		}
	}
	
	static String[] addBorder(String[] picture) 
	{
	    int len = picture[0].length();
	    String[] result = new String[picture.length+2];
	    result[0]= "*";
	    result[result.length-1]="*";
	    for(int i=0; i<len+1; i++)
	    {
	        result[0]=result[0]+"*";
	        result[result.length-1]=result[result.length-1]+"*";
	    }
	    int j=1;
	    while(j<result.length-1)
	    {
	    	System.out.println(j);
	    	char[] temp = picture[j-1].toCharArray();
	    	for(int i=0; i<len+2; i++)
	    	{
	    		
	    		if(i==0)
	    			result[j] = "*";
	    		else if (i==len+1)
	    			result[j] = result[j] + "*";
	    		else 
	    		{
	    			result[j] = result[j] + temp[i-1];
	    		}
	    	}
	    	j++;
	    }
	    return result;
	}
}
