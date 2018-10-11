
public class Robot 
{
					static int count = 0;		
					static int count1 = 0;
					public static void main(String[] args)
					{
								
						 				long l = 126, r = 1048575;
						 		
						 				long result = robotFunction( l , r );
						 				System.out.println(" output " +result);
							
								
					}
					
					public static long robotFunction( long l , long r)
					{

						long result =0;
						for (long j = l; j <= r; j++)
						{
								long temp = j;
								while( temp != 0)
									{
											if(  ( temp % 2 ) !=0 )
											{
													count++;
													temp = temp - 1 ;
											}
											else
											{
													temp = temp / 2;
													count1++;
													
											}
									}
									result = count * count1  + result;
									count = count1 = 0;
						}
									return result;
				
					}


}
