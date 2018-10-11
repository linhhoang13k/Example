import java.util.Arrays;


public class sample1 
{
				public static void main(String[] args)
				{
							  int[] lengths = {50, 48, 130, 131, 90, 80};
							  TetrahedronMaxFace(lengths);
							
						
				}

				static int[]  perimeter= new int[ 4 ] ;
				static double[] areas= new double[4] ;
				static int count = 0;
				static int[]  maxPerimeter;
				static int indexOfarrayOfMaxPerimeter ;
				static int counlines =0;
				static int index = 0;
				public static int TetrahedronMaxFace(int[] lengths) {
					maxPerimeter = new int[ 36 ] ;
					int max1 = 0;
					  indexOfarrayOfMaxPerimeter = 0;
					  for (int i = 0; i < lengths.length - 1; i++) 
					  {
						  		
						  		arrangeLengths(0, 1, 2, lengths, indexOfarrayOfMaxPerimeter);
						  		System.out.println("\n =============================================");
						  		swap( 0 , i + 1 , lengths);
						  		System.out.println("\n =============================================");
					  }
					  arrangeLengths(0, 1, 2, lengths, indexOfarrayOfMaxPerimeter);
					  System.out.println("\n =============================================");
					  swap( 0 , 2, lengths);
					  System.out.println("\n =============================================");
					  System.out.println("\n =============================================");
					  max1 = Arrays.stream(maxPerimeter).max().getAsInt();
					  System.out.println("\n Max    :" +max1 );
					  return max1;
				}
							
				private static void arrangeLengths(int i , int j, int k ,int[] lengths, int indexOfarrayOfMaxPerimeter )
				{							
							firstShuffle(lengths, i ,j ,k);
							
							countMaxPerimeter();
							
							swap(j, k, lengths);
							firstShuffle(lengths , i , j , k );
							countMaxPerimeter();
							
							swap( i , j , lengths);
							firstShuffle(lengths , i , j , k );
							countMaxPerimeter();
							
							
									 		
							swap(j, k, lengths);
							firstShuffle(lengths , i , j , k );
							countMaxPerimeter();
							
							
					 		
							swap(i, j , lengths);
							firstShuffle(lengths , i , j , k );
							countMaxPerimeter();
						
							
					 		
							swap(j, k, lengths);
							firstShuffle(lengths , i , j , k );
							countMaxPerimeter();
							
							swap(i, j, lengths);
						    
				}

				public static void countMaxPerimeter() {
					if (count == 5) 
					{
								 int max = 0;
						 		 max = Arrays.stream(perimeter).max().getAsInt();
						 		 System.out.println("\n Saving in maxPerimeter    :" +max );
						 		 maxPerimeter[indexOfarrayOfMaxPerimeter] = max;
								 indexOfarrayOfMaxPerimeter++;
								
					}
					count = 0;
				}
							

				public static void firstShuffle(int[] lengths, int i, int j, int k)
				{
					index=0;
					count =0;
							System.out.println("/n countlines   " +counlines++);
							System.out.println(" \n" + lengths[0]+  "  "  + lengths[1]+  "  "  +lengths[2]);
							findArea( 0 , 1 , 2 , lengths );
							
							System.out.println(" \n" + lengths[0]+  "  "  + lengths[3]+  "  "  +lengths[5]);
							findArea( 0 , 3 , 5 , lengths );
							
							System.out.println(" \n" + lengths[1]+  "  "  + lengths[3]+  "  "  +lengths[4]);									
							findArea( 1 , 3 , 4 , lengths );
							
							System.out.println(" \n" + lengths[2]+  "  "  + lengths[4]+  "  "  +lengths[5]);
							findArea( 2 , 4 , 5 , lengths );
							
							validityOfTriangle( areas );
							
							System.out.println("\n ====================================");
							
				}
				
				private static void validityOfTriangle(double[] areas2) 
				{
							if( ( areas2[0] < (areas2[1] + areas2[2] + areas2[3] ) )   &&  (areas2[1] < (areas2[0] + areas2[1] + areas2[2] ) )  && ( areas2[2] < (areas2[0] + areas2[1] + areas2[3]  ))  &&  ( areas2[3] < (areas2[0] + areas2[1] + areas2[2] )) )
							{
										count++;
							}
				}

				private static double[] findArea( int i, int j, int k, int[] lengths) 
				{
							int a = lengths[i];
							int b = lengths[j];
							int c = lengths[k];
							
							float p = ( a + b + c )/ 2;
														
							
							
							if  (    ( a + b  >  a)  &&   ( c + b >  a)   &&    ( a + c >  b)    )
							{
												perimeter[index] = a + b + c; 
												areas[index] =  (double) Math.sqrt( p	* (	p - a ) *	( p	 - b) * ( p	- c )) ;
												count++;
												System.out.println(" \n  perimeter   " + perimeter[index]);
							}
							else
							{
								areas[index] = Integer.MAX_VALUE;
								perimeter[index] = 0;
							}
							
							index++;
							return areas;
				}
				
				
				private static void swap(int i, int j, int[] lengths)
				{
							int swapVar = lengths[j];
							lengths[j] = lengths[i] ;
							lengths[i] = swapVar ;
							
				}

				
	
}
