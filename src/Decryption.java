

public class Decryption 
{
					public static void main(String[] args)
					{
						
								int[] bytelist = {73, 39, 36, 121, 116, 0, 2, 72, 126, 10, 6, 119, 7, 126, 50, 6, 65, 123, 63, 100, 33, 14, 4, 120, 92, 79}; 
								String result = decryption(bytelist);
								
								//for (int i = 0; i <= bytelist.length - 1; i++) 
								{
									System.out.print(result);
								}
					}
					static String  decryption(int[] bytelist) 
					{
								char[] output = new char[bytelist.length];
								String outputString = "";
								int result1 = 0;
								int result2 = 0;
								
								for (int i = 0; i <= bytelist.length -1 ; i++) 
								{
										
										if ( i % 2 == 0) 
										{
												    result1= (bytelist[i] + result1);
												    result1 = CheckLessThen126(result1);
												    output[i] = (char) result1;
										}
										else
										{
													result2= (char) (bytelist[i] + result2);
													result2 = CheckLessThen126(result2);
													output[i] =  (char) result2;
										}
								}
								
								for (int i = 0; i < output.length; i++) 
								{
										outputString += output[i];
								}
								return outputString;
					}
					
					private static int CheckLessThen126(int result1) 
					{
						if (result1 > 128) 
						{
							result1 = result1 - 128 ;
						}
						return result1;
						
					}
}
