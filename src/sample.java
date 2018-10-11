
public class sample 
{
				static int[]  perimeter= new int[ 6] ;
				static int count = 0;
			
				public static void main(String[] args)
				{
							  String[] lengths = {"2017","2016", "2015","5","4","3"};
							
							
							for (int i = 0; i < lengths.length - 1; i++) 
							{
										arrangeLengths(lengths);
										swap( 0 , i + 1 , lengths);	;
							}
								
								//System.out.println(" \n" + temp);
						
							
							//swap( 0 ,  5 , lengths);
								arrangeLengths(lengths);	
							
							//String finalPerimeter = TetrahedronMaxFace(lengths);
			
				}
				
				
				
				private static void arrangeLengths(String[] lengths) 
				{
							int[] tempArray = new int[6];
							tempArray = parseInt( 0 , 1 , 2 , lengths);
							System.out.println(" \n" + tempArray[0]+  "  "  + tempArray[1]+  "  "  +tempArray[2]);
							
							
							tempArray = parseInt( 0 , 3 , 5 , lengths);
							System.out.println(" \n" + tempArray[0]+  "  "  + tempArray[1]+  "  "  +tempArray[2]);
														
							tempArray = parseInt( 1 , 3 , 4 , lengths);
							System.out.println(" \n" + tempArray[0]+  "  "  + tempArray[1]+  "  "  +tempArray[2]);
							
							tempArray = parseInt( 2 , 4 , 5 , lengths);
							System.out.println(" \n" + tempArray[0]+  "  "  + tempArray[1]+  "  "  +tempArray[2]);
							
							if(count == 4)
							{
									
							}
					
				}



				private static int[] parseInt(int i, int j, int k, String[] lengths) 
				{
							int[] tempArray1 = new int[6];
							tempArray1[0] = Integer.parseInt(lengths[i]);
							tempArray1[1] = Integer.parseInt(lengths[j]);
							tempArray1[2] = Integer.parseInt(lengths[k]);
							count  = findPerimeter( tempArray1 , 0 , 1 , 2 ,lengths );
							
							return tempArray1;
				}



				private static int findPerimeter(int[] tempArray, int i, int j, int k, String[] lengths) {
								int a = tempArray[i];
								int b = tempArray[j];
								int c = tempArray[k];
								
								if  (    ( a + b >=  c)  &&   ( c + b >=  a)   &&    ( a + c >=  b)    )
								{
										for (int l = 0; l < perimeter.length; l++) 
										{
											perimeter[l] = a + b + c; 
											count++;
											System.out.println(" \n  perimeter   " + perimeter[l]);
											if(count == 4)
											{
												break;
											}
											arrangeLengths(lengths);
											
										}
										
								}
								
								return count;
				}
				
				private static void swap(int i, int j , String[] lenghts)
				 {
							 	String swapVar = lenghts[j];
							 	lenghts[j] = lenghts[i] ;
								lenghts[i] = swapVar ;
				}
}
