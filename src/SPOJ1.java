import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int number;
		do
		{
			Scanner in = new Scanner(System.in);
			number = in.nextInt();
			if(number != 42)
			{
				System.out.println(number);	
			}
		}
		while(number != 42);
	}
}