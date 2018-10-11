package test;

import java.util.Arrays;

public class CheckPolyndrome {
	
	public boolean poly(String inout)
	{

		    char[] temp = new char[inout.length()];
		    
		    for (int i=0;i<inout.length(); i++)
		    {
		    	temp[i] = inout.charAt(i);
		    }
		    for(int i=0, j=inout.length()-1; i<inout.length(); i++,j--){
		    	
		    	if (temp[i] != temp[j]) return false;
		    	  
		    	}
		    return true;
		}
	
	public static void main (String args[]) {
		CheckPolyndrome c = new CheckPolyndrome();
		System.out.println(c.poly("danda"));
	}
	}



