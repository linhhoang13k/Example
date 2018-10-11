import javax.xml.soap.SAAJResult;

public class tetrahedron {
			static String[] temp;
			static int  perimeter = 0; 
			public static void main(String[] args)
			{
						String[] lengths = {"2017","2016", "2015","5","4","3"};
						
						for (int i = 1; i <= lengths.length - 1 ; i++) 
						{
							arrangeLengths(lengths);	
							swap( 0 , i , lengths);	
							//System.out.println(" \n" + temp);
						}
						
						swap( 0 ,  5 , lengths);
							arrangeLengths(lengths);	
						
						String finalPerimeter = TetrahedronMaxFace(lengths);
		
			}
			 private static void swap(int i, int j , String[] lenghts)
			 {
				 	String swapVar = lenghts[j];
				 	lenghts[j] = lenghts[i] ;
					lenghts[i] = swapVar ;
			}
			static String TetrahedronMaxFace(String[] lengths) 
			 {
				 		
				 		return null;
		
			 }
	 
	 
	 
	 	
			private static void arrangeLengths(String[] lengths) 
	 		{
	 			
			 			for (int i = 0; i < lengths.length -2; i++)
						{
			 					int[] temp1 = new int[6] ;
								temp1[0] =  Integer.parseInt (lengths[0]);
								temp1[1] =  Integer.parseInt (lengths[i+1]);
								temp1[2] =  Integer.parseInt ( lengths[i+2] ) ;
								System.out.println(" \n" + temp1[0]+  "  "  + temp1[1]+  "  "  +temp1[2]);
								
								perimeter = findPerimeter( temp1 , 0 , 1 , 2 );
								System.out.println(" \n  perimeter   " + perimeter);
								perimeter=0;
								temp1 = null;
						}
			 			
			 		
						//arrangeLengths(lengths);
			}
	 		
	 		
			private static int findPerimeter(int[] temp1, int i, int j, int k) 
			{
						int a = temp1[i];
						int b = temp1[j];
						int c = temp1[k];
						
						if  (    ( a + b >=  c)  &&   ( c + b >=  a)   &&    ( a + c >=  b)    )
						{
								perimeter = a + b + c; 
						}
						
						return perimeter;

			}
		

}
