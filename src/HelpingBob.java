public class HelpingBob
{
	
	static int x =4;
	static int y =3;
	static int k =12;
	
	static String[] possiblePaths = new String[ x + y ];
	public static void main(String[] args) 
	{			
				 helpingBob(x, y, k);
			
	}
		private static void helpingBob(int x2, int y2, int k2)
		{
			for (int i = 0; i < x; i++) 
			{
					possiblePaths[i] = "H" ;
			}
			
			for (int i = x; i < x + y ; i++) 
			{
					possiblePaths[i] = "V" ;
			}
			
				findFinalPath();
		}
		
		private static void findFinalPath()
		{
					firstPartOfSorting();
			
		}
		private static void firstPartOfSorting() 
		{
					for (int i = x; i < x + y; i++) 
					{
						swapHandV(i - 1 , i , possiblePaths);
						for (int k = 0; k < x + y ; k++) 
						{
								System.out.print("  " +possiblePaths[k]);
						}
						System.out.print("\n----------------------");
						
					}
					secondPartOfSorting();
			
		}
		
		
		private static void secondPartOfSorting() 
		{
							
							swapHandV(0 ,  x - 1 , possiblePaths);
							swapHandV(x + y - 1 ,  x  , possiblePaths);
							for (int k = 0; k < x + y ; k++) 
							{
									System.out.print("  " +possiblePaths[k]);
							}
							System.out.print("\n----------------------");
							
							for (int i = x; i < x + y -1; i++) 
							{
								swapHandV(i , i + 1 , possiblePaths);
								for (int k = 0; k < x + y ; k++) 
								{
										System.out.print("  " +possiblePaths[k]);
								}
								System.out.print("\n----------------------");
							}
							swapHandV(1 ,  x  , possiblePaths);
							swapHandV(x + y - 1 ,  x + 1  , possiblePaths);
							for (int k = 0; k < x + y ; k++) 
							{
									System.out.print("  " +possiblePaths[k]);
							}
							System.out.print("\n----------------------");
		}
		
		public static void swapingLatters(boolean first) {
			
			int numToAdd = first ? 0:1;
			swapHandV(numToAdd ,  x - 1 + numToAdd , possiblePaths);
			swapHandV(x + y - 1 ,  x + numToAdd  , possiblePaths);
		}
		
		private static void swapHandV(int i, int j, String[] possiblePaths2)
		{
				String swapVar = possiblePaths2[j];
				possiblePaths2[j] = possiblePaths2[i] ;
				possiblePaths2[i] = swapVar ;
		}
}