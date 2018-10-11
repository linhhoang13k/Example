public class smape 
{
	static int x =2;
	static int y =2;
	static int k =2;
	
	static String[] possiblePaths = new String[ x + y ];
	public static void main(String[] args) 
	{			
				 helpingBob(x, y, k);
			
	}
	
			static void helpingBob(int x, int y, int k)
			{
				for (int i = 0; i < x; i++) 
				{
						possiblePaths[i] = "H" ;

						System.out.print(possiblePaths[i]);
				}
				
				for (int i = x; i < x + y ; i++) 
				{
						possiblePaths[i] = "V" ;

						System.out.print(possiblePaths[i]);
				}
				
				findFinalPath( possiblePaths);
					

			}

			private static void findFinalPath(String[] possiblePaths2)
			{
							int i = x - 1;
							for (int j = x ; j < x + y ; j++ ) 
							{
									
									swapHandV( i , j ,possiblePaths2);
									for (int k = 0; k < x + y ; k++) 
									{
											System.out.print("  " +possiblePaths[k]);
									}
									System.out.print("\n----------------------");
									i++;
							}
							
							secondPartOfSorting(possiblePaths2);
					
					//return null;
			}

			private static void secondPartOfSorting(String[] possiblePaths2) 
			{
						
						for (int i = 0; i < x+y-2; i++)
						{
									swapHandV( i , i+1 , possiblePaths2 ) ;
									swapHandV( i + 2 , x+y - 1, possiblePaths2);
									System.out.print("\n----------------------");
									for (int k = 0; k < x + y ; k++) 
									{
											System.out.print("  " +possiblePaths[k]);
									}
									

									int k = x ;
									for (int j = x +1 ; j < x + y ; j++ ) 
									{
											
											swapHandV( k , j ,possiblePaths2);
											System.out.print("\n----------------------");
											k++;
									}
									for (int z = 0; z < x + y ; z++) 
									{
											System.out.print("  " +possiblePaths2[k]);
									}
								
						}
				
			}

			private static void swapHandV(int i, int j, String[] possiblePaths2)
			{
					String swapVar = possiblePaths2[j];
					possiblePaths2[j] = possiblePaths2[i] ;
					possiblePaths2[i] = swapVar ;
			}

}

