package test;

public class ElementProduct {
	
	int adjacentElementsProduct(int[] inputArray) {
		
		int prod[] = new int[inputArray.length-1];
		prod[0] = 0;
		
		for (int i=0;i<prod.length;i++)
		{
			prod[i] = inputArray[i] * inputArray[i+1];
		}
		
		for (int i=0;i<prod.length;i++)
		{
			for (int j=0;j<prod.length;j++)
			{
				if (prod[i] > prod[j])
				{
					int high = prod[i];
					prod[i] = prod[j];
					prod[j] = high;
				}
			}
		}
		
		return prod[0];

	}


	public static void main(String args[])
	{
		ElementProduct e =new ElementProduct();
		int[] inputArray = { 3,5,7,9,-1,2,1};
		System.out.println(e.adjacentElementsProduct(inputArray));
	}

}
