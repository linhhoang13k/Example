public class DigitOrdering {
public int[] max(int num1)
		{
		int a;int loop=0;
		int num=num1;
		while(num>0)
		{
		num=num/10;
		loop++;
        }
        int arr[]= new int[loop];
		while(num1>0)
		{
		a=num1%10;
		arr[--loop]=a;
		num1=num1/10;
        }        
        int n=arr.length;
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < n; j++)
                {if (arr[j] > arr[max_idx])
                    max_idx = j;}
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
	public int[] min(int num1)
		{
		int a;int loop=0;
		int num=num1;
		while(num>0)
		{
		num=num/10;
		loop++;
        }
        int arr[]= new int[loop];
		while(num1>0)
		{
		a=num1%10;
		arr[--loop]=a;
		num1=num1/10;
        }        
        int n=arr.length;
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
		
	//Function
	public int orderDigits(int input) {
		// Student code begins here
		int a,b;a=0;b=0;
		if (input<0)
		{
			input=-input;
			int array[]=max(input);
			for(int i=0;i<(array.length);i++)
			b=b*10+array[i];
			return -b;
		}
		else
		{
			int array[]=min(input);
			for(int i=0;i<(array.length);i++)
			{
				a=a*10+array[i];
			}
			return a;
		}
		// Student code ends here
	}

	public void printOrderedDigits(int input) {
		System.out.println(orderDigits(input));
	}

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Exactly 1 input required.");
			return;
		}
		try {
			int input = Integer.parseInt(args[0]);
			DigitOrdering obj = new DigitOrdering();
			obj.printOrderedDigits(input);
		} catch (NumberFormatException e) {
			System.out.println("Only integer allowed.");
		}
	}
}
