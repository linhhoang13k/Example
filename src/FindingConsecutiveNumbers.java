package test;

public class FindingConsecutiveNumbers {
	
	int makeArrayConsecutive2(int[] statues) {

	    int min =statues[0];
	    int max = statues[0];
	    
	    for (int i=0;i<statues.length;i++)
	    {
	    	for (int j=0;j<statues.length;j++)
	    	{
	    		if (statues[i] < statues[j] && statues[i] < min) min = statues[i];
	    		else if (statues[j] >  max) max = statues[j];
	    	}
	    }
	    System.out.println(max + " "+min);
		return max-min-statues.length+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] statues = { 6,2,9,10 };
		
		FindingConsecutiveNumbers c = new FindingConsecutiveNumbers();
		System.out.println(c.makeArrayConsecutive2(statues));

	}

}
